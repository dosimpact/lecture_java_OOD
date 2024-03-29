import java.util.Date;

// http://www.kma.go.kr/HELP/basic/help_01_04.jsp
// HeatIndex (KPARK 2020/09/27)
enum HeatIndex  {
	VERY_HIGH, HIGH, USUAL, LOW;
}

public class HeatIndexDisplay implements Observer,DisplayElement {
	private HeatIndex index = null;
	
    // fahrenheit -> celsius
	static double fromFahrenheitToCelsius(double F) {
        return (F - 32.0) * (5.0 / 9.0);
    }

	// celsius -> fahrenheit
	static double fromCelsiusToFahrenheit(double C) {
        return ((9.0 / 5.0) * C + 32.0);
    }

	// HI = -42.379 + (2.04901523*F) + (10.14333127*R) - (0.22475541*F*R) - (0.00683770*F*F) - (0.05481717*R*R) + (0.00122874*F*F*R) + (0.00085282*F*R*R) - (0.00000199*F*F*R*R) [F: temperature (fahrenheit), R: relativeHumidity (%)]
	public static double calculate(double T, double R) {
		double F = fromCelsiusToFahrenheit(T);
		double value = -42.379 + (2.04901523*F) + (10.14333127*R) - (0.22475541*F*R) - (0.00683770*F*F) - (0.05481717*R*R) + (0.00122874*F*F*R) + (0.00085282*F*R*R) - (0.00000199*F*F*R*R);		

		double adj = 0.0;
        if (R < 13.0 && F >= 80.0 && F <= 112.0) {
            adj = 0.25 * (13.0 - R) * Math.sqrt((17.0 - Math.abs(F - 95.0)) / 17.0);
        }
        if (R > 85.0 && F >= 80.0 && F <= 87) {
            adj = (R - 85.0)/10.0 * (87.0 - F) / 5.0;
            value += adj;
        }
        if (F < 80.0) {
        	value = F;
        }
        value = fromFahrenheitToCelsius(value); // (celsius)
        value = Math.round(value * 10) / 10.0; // round

        return value;
	}
	
	@Override
	public String toString() {
		return "HeatIndexDisplay [index=" + index + "]";
	}

	@Override
	public void update(Date dateTime, double temp, double velocity, double humidity) {
		// subject에서 업데이트 신호가 오면, 데이터를 가공 및 저장 후에 display 실행
		double result = HeatIndexDisplay.calculate(temp, humidity);
		if(result  >= 54) {
			this.index = HeatIndex.VERY_HIGH;
		} else if(result >= 41) {
			this.index = HeatIndex.HIGH;
		}
		else if(result >= 32) {
			this.index = HeatIndex.USUAL;
		}
		else {
			this.index = HeatIndex.LOW;
		}
		display();
	}

	@Override
	public void display() {
		System.out.println(this);//toString 실행
		
	}
	
	@Override
	public boolean equals(Object o){
		return ( o instanceof HeatIndexDisplay); // indexOf를 결정하기 위한 코드
	}
}

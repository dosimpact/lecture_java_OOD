package lab09;

public interface State {
	// 4가지 State를 변화 갖는다. 
	void plus();	// 기호를 변경하는 액션
	void minus();	// 기호를 변경하는 액션
	void dot(); 	// 점으로 넘어가는 액션
	void digit();	// 숫자를 추가하는 액션
	void other();	// 애러로 액션
}

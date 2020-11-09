package undo.command;

// 커맨드 패턴의 인터페이스
public interface Command {
	void execute();
	void undo();
}

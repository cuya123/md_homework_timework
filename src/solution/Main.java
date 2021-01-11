package solution;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

public class Main {

	public static void main(String[] args) {

		String now = "14:00:00";

		WorkingTime wt = new WorkingTime();

		try {

			int result = wt.getPersonCount(now);
			System.out.println("회사에 있는 인원은: " + result + "명 입니다");

		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않음");
		} catch (IOException e) {
			System.out.println("파일을 읽을수 없음");
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("날짜 형식 오류");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
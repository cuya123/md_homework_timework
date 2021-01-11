package solution;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WorkingTime {
	
	final static String filePath = "src/time_data.txt";
	final static SimpleDateFormat transFormat = new SimpleDateFormat("HH:mm:ss");

	public int getPersonCount(String now) throws Exception{
		
		//현재 인원수
		int cnt=0;
		//시간을 Date객첵로 변환
		Date currentDate = transFormat.parse(now);
		
		StringBuffer sb = new StringBuffer();	
		FileInputStream fis = new FileInputStream(filePath); //파일stream
		int index = 0; 
		
		while(index != -1) {
			
			//한바이트를 읽는다
			index = fis.read();
			
			char c = (char)index;
			
			//개행문자가 나오면
			if(c == '\n' || c=='\r') {
				//(개행이 연속해서 나올경우 대비) 버퍼에 문자열없으면 다음 문자열 읽음
				if(sb.length()==0) {
					continue;
				}
				//공백을 기준으로 자른다
				String[] sa = sb.toString().split(" ");
				
				Date start_date = transFormat.parse(sa[0]);
				Date end_date = transFormat.parse(sa[1]);
				
				//현재와 출근시각이 같거나 그 이전인 동시에
				//현재와 퇴근시각이 같거나 그 이후면 회사에 존재하므로 카운트 업
				if(!start_date.after(currentDate) && !end_date.before(currentDate)) {
					cnt++;
				}
				//개행시 버퍼 초기화
				sb.setLength(0);
			}
			//개행문자가 아닐경우
			else {
				//아니면 스트링버퍼에 저장
				sb.append(c);
			}
		}

		return cnt; 
		
	}
	
}

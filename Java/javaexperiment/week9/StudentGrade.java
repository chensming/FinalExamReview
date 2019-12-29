//第六题
import java.io.*;
//import java.util.StringTokenizer;


public class StudentGrade {
	public static void main(String args[]) {
		//学生人数
		final int STUDENTNUM = 30;
		String input = "D:/Desktop/vscodeProject/javaProject/javaLab/week9/otherFiles/ingrade.txt";
		String output = "D:/Desktop/vscodeProject/javaProject/javaLab/week9/otherFiles/outgrade.txt";
		try (FileReader reader = new FileReader(input);
				BufferedReader br = new BufferedReader(reader)
				){
			try(FileWriter writer = new FileWriter(output);
					BufferedWriter bw = new BufferedWriter(writer)
					){
				int i = 0;
				String[] names = new String[30];
				double[] scores = new double[30];
				String line;
				while((line = br.readLine()) != null) {
					String [] arr = line.split("\\s+");
					names[i] = arr[0];
					scores[i] = Double.parseDouble(arr[1]);
					i++;
					//测试
//					System.out.print(i + ", name: " + arr[0]);
//					System.out.println(" ,score: " + arr[1]);
				}
				
				double maxScore = scores[0];
				double minScore = scores[0];
				double averageScore = scores[0];
				String maxScoreStudent = names[0];
				String minScoreStudent = names[0];
				for(i = 1; i < 30 ; i++) {
					if(maxScore < scores[i]) {
						maxScore = scores[i];
						maxScoreStudent = names[i];
					}
					if(minScore > scores[i]) {
						minScore = scores[i];
						minScoreStudent = names[i];
					}
					averageScore += scores[i];
				}
				averageScore /= STUDENTNUM;
				bw.write("最高分: " + maxScore + ",学生名字: " + maxScoreStudent);
				bw.write("\n最低分: " + minScore + ",学生名字: " + minScoreStudent);
				bw.write("\n平均分: " + averageScore);
				
				//测试
//				System.out.println("最高分: " + maxScore + ",学生名字: " + maxScoreStudent);
//				System.out.println("最低分: " + minScore + ",学生名字: " + minScoreStudent);
//				System.out.println("平均分: " + averageScore);
				System.out.println("run and save to file successfully");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

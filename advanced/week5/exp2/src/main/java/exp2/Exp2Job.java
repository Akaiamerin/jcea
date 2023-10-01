package exp2;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
public class Exp2Job implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        try {
            JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
            String path = jobDataMap.getString("PATH3");
            BufferedWriter bw = new BufferedWriter(new FileWriter(path, true));
            String str = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy 年 MM 月 dd 日 HH 时 mm 分 ss 秒"));
            bw.write(str);
            bw.newLine();
            bw.flush();
            System.out.println(str);
        }
        catch (IOException exc) {
            exc.printStackTrace();
        }
        finally {
            if (bw != null) {
                try {
                    bw.close();
                }
                catch (IOException exc) {
                    exc.printStackTrace();
                }
            }
        }
    }
}
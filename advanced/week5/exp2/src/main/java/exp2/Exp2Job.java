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
        BufferedWriter bw = null;
        try {
            JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
            String path = jobDataMap.getString("path");
            bw = new BufferedWriter(new FileWriter(path, true));
            String str = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒"));
            bw.write(str);
            bw.newLine();
            bw.flush();
            System.out.println(str);
        }
        catch (IOException exc) {
            exc.printStackTrace();
        }
        finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            }
            catch (IOException exc) {
                exc.printStackTrace();
            }
        }
    }
}
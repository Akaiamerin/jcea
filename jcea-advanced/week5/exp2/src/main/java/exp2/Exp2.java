package exp2;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
public class Exp2 {
    public static void ScheduledTask1(String path) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                BufferedWriter bw = null;
                try {
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
        }, 0, 5000);
    }
    public static void ScheduledTask2(String path) {
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(1, Executors.defaultThreadFactory());
        threadPool.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                BufferedWriter bw = null;
                try {
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
        }, 0, 5000, TimeUnit.MILLISECONDS);
    }
    public static void ScheduledTask3(String path) {
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            JobDetail jobDetail = JobBuilder.newJob(Exp2Job.class).withIdentity("jobDetail1", "group1").usingJobData("path", path).build();
            CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("cronTrigger1", "group1").startNow().withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")).build();
            scheduler.scheduleJob(jobDetail, cronTrigger);
            scheduler.start();
            Thread.sleep(Long.MAX_VALUE);
            scheduler.shutdown();
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }
    public static void main(String[] args) {
        String path1 = "./src/main/resources/scheduled-task1.txt";
        String path2 = "./src/main/resources/scheduled-task2.txt";
        String path3 = "./src/main/resources/scheduled-task3.txt";
        ScheduledTask1(path1);
        ScheduledTask2(path2);
        ScheduledTask3(path3);
    }
}
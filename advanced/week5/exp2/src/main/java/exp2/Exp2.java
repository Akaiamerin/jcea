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
    private static final String PATH1 = "./src/main/resources/scheduled_task_by_timer.txt";
    private static final String PATH2 = "./src/main/resources/scheduled_task_by_scheduled_executor_service.txt";
    private static final String PATH3 = "./src/main/resources/scheduled_task_by_quartz.txt";
    public static void ScheduledTaskByTimer() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(PATH1, true));
                    String str = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy 年 MM 月dd 日 HH 时 mm 分 ss 秒"));
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
        }, 0, 5000);
    }
    public static void ScheduledTaskByScheduledExecutorService() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1, Executors.defaultThreadFactory());
        executor.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(PATH2, true));
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
        }, 0, 5000, TimeUnit.MILLISECONDS);
    }
    public static void ScheduledTaskByQuartz() {
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            JobDetail jobDetail = JobBuilder.newJob(Exp2Job.class).withIdentity("jobDetail1", "group1").usingJobData("PATH3", PATH3).build();
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
        ScheduledTaskByTimer();
        ScheduledTaskByScheduledExecutorService();
        ScheduledTaskByQuartz();
    }
}
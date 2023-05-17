package in.project.Activelife.countstep;

import static android.content.ContentValues.TAG;

import static androidx.core.app.ActivityCompat.requestPermissions;

import android.Manifest;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;


public class StepsService extends Service implements SensorEventListener  {

    private SensorManager mSensorManager;
    private Sensor mStepDetectorSensor;
    private int stepcount=0;
    private int step=0;
    private StepsDBHelper mStepsDBHelper;
    private SharedPreferences sharedPreferences;



    @Override
    public void onCreate() {
        super.onCreate();
        sharedPreferences = this.getApplicationContext().getSharedPreferences("myinfPrefs01", Context.MODE_PRIVATE);


        mSensorManager = (SensorManager)
                this.getSystemService(Context.SENSOR_SERVICE);


      /*  if (mSensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR) != null) {
            mStepDetectorSensor =
                    mSensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);
            mSensorManager.registerListener(this, mStepDetectorSensor, SensorManager.SENSOR_DELAY_NORMAL);
            mStepsDBHelper = new StepsDBHelper(this);
            step=mStepsDBHelper.readSteptoday();
        }
        else {*/
        if (mSensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER) != null) {
            mStepDetectorSensor =
                    mSensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
            mSensorManager.registerListener(this, mStepDetectorSensor, SensorManager.SENSOR_DELAY_NORMAL);
            mStepsDBHelper = new StepsDBHelper(this);
            step = mStepsDBHelper.readSteptoday();

        } else {
            Toast.makeText(this, "No sensor detected on this device", Toast.LENGTH_LONG).show();
        }
        /* }*/






    }

    @Override
    public void onStart(Intent intent, int startId) {

        super.onStart(intent, startId);
    }
    @Override
    public void onDestroy() {


    }

    public int getStep() {
        return step;
    }

    public void setStepcount(int stepcount) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt("STEPCOUNTER", stepcount);
        edit.apply();
    }

    public int getStepcount() {
        this.stepcount= sharedPreferences.getInt("STEPCOUNTER",-1);
        return this.stepcount;
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int
            startId) {
        return Service.START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        int stepcountnow = (int) event.values[0];
        int stepcount=getStepcount();

        if (stepcount == -1)
        {
            setStepcount(stepcountnow);
        }
        if(stepcountnow==0)
        {
            setStepcount(0);
        }
        stepcount=getStepcount();
        mStepsDBHelper.createStepsEntry(stepcountnow-stepcount);
        setStepcount(stepcountnow);


        // lấy ra hiện tại trừ trước đó -> lưu( stepcount - stepcountsave =stepchange)
        // rest may SensorEvent.values[0]=0 stepcountsave >0  ( stepcount - stepcountsave =stepchange<0)-> stepsave=0;
        /*  lúc cài đặt thì nếu+thì nó sẻ lấy stepcount lúc onCreate
         hoạt động stepcount - stepcountsave =stepchange
           lưu thêm vào csdl + set stepcountsave=stepcount*/

       /* mStepsDBHelper.createStepsEntry();*/
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

}
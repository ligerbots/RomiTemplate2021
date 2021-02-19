package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.sensors.RomiGyro;

public class DriveTrain extends SubsystemBase{

    private final Spark leftMotor = new Spark(0);
    private final Spark rightMotor = new Spark(1);

    private final Encoder leftEncoder = new Encoder(4, 5);
    private final Encoder rightEncoder = new Encoder(6, 7);

    //clockwise for left wheel is forwards, opposite for left
    private final DifferentialDrive diffDrive = new DifferentialDrive(leftMotor, rightMotor);

    private DifferentialDriveOdometry odometry = new DifferentialDriveOdometry(new Rotation2d(0.0));

    private final RomiGyro gyro = new RomiGyro();

    private final double countsPerRevolution = 1440.0;
    private final double wheelDiameterInch = 2.75591;
    
    public DriveTrain(){
        leftEncoder.setDistancePerPulse((wheelDiameterInch * Math.PI) / countsPerRevolution);
        rightEncoder.setDistancePerPulse((wheelDiameterInch * Math.PI) / countsPerRevolution);

        resetEncoders();
    }

    public void resetEncoders(){
        leftEncoder.reset();
        rightEncoder.reset();
    }

    public void drive(double speed, double rotate){
        diffDrive.arcadeDrive(speed, rotate, true);
    }
}

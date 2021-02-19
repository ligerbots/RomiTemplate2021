package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class DriveCommand extends CommandBase{

    private final DriveTrain driveTrain;
    private final Supplier<Double> speedSupplier;
    private final Supplier<Double> rotationSupplier;

    public DriveCommand(DriveTrain driveTrain, Supplier<Double> speedSupplier, Supplier<Double> rotationSupplier){
        this.driveTrain = driveTrain;
        this.speedSupplier = speedSupplier;
        this.rotationSupplier = rotationSupplier;
        addRequirements(driveTrain);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        driveTrain.drive(speedSupplier.get(), rotationSupplier.get());
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}

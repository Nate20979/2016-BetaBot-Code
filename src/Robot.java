package src;

// Imports the other files needed by the program
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Robot extends IterativeRobot {

    // Defines the variables as members of our Robot class
    RobotDrive myRobot;
    Joystick stick;


    TimeWatch timeWatch;

    // Initializes the variables in the robotInit method, this method is called when the robot is initializing
    public void robotInit() {
        myRobot = new RobotDrive(0, 1);
        stick = new Joystick(1);
    }

    public void autonomousInit() {
        // This method is called once each time the robot enters autonomous mode

        // Start the timer
        timeWatch = TimeWatch.start();
    }

    public void autonomousPeriodic() {
        // This method is called each time the robot recieves a packet instructing the robot to be in autonomous enabled mode

        // If we have driven for less than 5 seconds,
        // drive forwards
        if (timeWatch.time() <= 5) {
            myRobot.drive(-0.5, 0.0);
        }
        // Otherwise, stop
        else {
            myRobot.drive(0.0, 0.0);
        }

    }

    public void teleopInit() {
        // The teleopInit method is called once each time the robot enters teleop mode

        // Restart the timer
        timeWatch.restart();
    }

    public void teleopPeriodic() {
        // The teleopPeriodic method is entered each time the robot receives a packet instructing it to be in teleoperated enabled mode

        // This line drives the robot using the values of the joystick and the motor controllers selected above
        myRobot.arcadeDrive(stick);
    }

    public void testPeriodic() {
        // LiveWindow.run();
    }
}

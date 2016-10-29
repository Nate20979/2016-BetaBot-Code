// TODO: Use TimeWatch class instead of relying on the 20ms packet timings

// Imports the other files needed by the program
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Robot extends IterativeRobot {

    // Defines the variables as members of our Robot class
    RobotDrive myRobot;
    Joystick stick;

    int autoLoopCounter;

    // Initializes the variables in the robotInit method, this method is called when the robot is initializing
    public void robotInit() {
        myRobot = new RobotDrive(0, 1);
        stick = new Joystick(1);
    }

    public void autonomousInit() {
        // This method is called once each time the robot enters autonomous mode

        // This resets the loop counter to 0
        autoLoopCounter = 0;
    }

    public void autonomousPeriodic() {
        // This method is called each time the robot recieves a packet instructing the robot to be in autonomous enabled mode

        // Checks to see if the counter has reached 100 yet
        if (autoLoopCounter < 100) {
            // If the robot hasn't reached 100 packets yet, the robot is set to drive forward at half speed, the next line increments the counter by 1
            myRobot.drive(-0.5, 0.0);
            autoLoopCounter++;
        }
        else {
            // If the robot has reached 100 packets, this line tells the robot to stop
            myRobot.drive(0.0, 0.0);
        }
    }

    public void teleopInit() {
        // The teleopInit method is called once each time the robot enters teleop mode
    }

    public void teleopPeriodic() {
        // The teleopPeriodic method is entered each time the robot receives a packet instructing it to be in teleoperated enabled mode

        // This line drives the robot using the values of the joystick and the motor controllers selected above
        myRobot.arcadeDrive(stick);
    }

    public void testPeriodic() {
        LiveWindow.run();
    }
}
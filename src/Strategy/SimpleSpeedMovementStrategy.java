package Strategy;

public class SimpleSpeedMovementStrategy implements MovementStrategy {
    @Override
    public float setAverageSpeed() {
        return 60.0f;
    }
}

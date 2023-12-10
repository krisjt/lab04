package lab04client.measurementStation;

public class OneMeasurementStation {
    public int id;
    public int stationId;
    public Param param;
    public OneMeasurementStation(){}

    @Override
    public String toString() {
        return "OneMeasurementStation{" +
                "id=" + id +
                ", stationId=" + stationId +
                ", param=" + param +
                '}';
    }
}

package utilities.output;

public class DefaultOutputProducer implements OutputProducer{

    @Override
    public void produce(String output) {
        System.out.println(output);
    }
}

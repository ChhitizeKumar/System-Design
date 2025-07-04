public class Main {
    public static void main(String[] args) {

        System.out.println("=== Neural Network Training ===");
        ModelTrainer modelTrainer = new NeuralNetworkTrainer();
        modelTrainer.trainPipeline("data/images/");

        System.out.println("\n=== Decision Tree Training ===");
        ModelTrainer dtTrainer = new DecisionTreeTrainer();
        dtTrainer.trainPipeline("data/iris.csv");
    }
}
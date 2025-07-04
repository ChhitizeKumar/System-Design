public class DecisionTreeTrainer extends ModelTrainer{

    // Use the default preprocessData() (train/test split + normalize)

    @Override
    protected void train() {
        System.out.println("[DecisionTree] Building decision tree with max_depth=5");
        // pseudo-code: recursive splitting on features...
    }

    @Override
    protected void evaluate() {
        System.out.println("[DecisionTree] Computing classification report (precision/recall)");
    }
    // use the default saveModel()
}

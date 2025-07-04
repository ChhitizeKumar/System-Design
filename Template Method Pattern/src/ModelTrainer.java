public abstract class ModelTrainer {

    protected void loadData(String path)
    {
        System.out.println("[Common] Loading dataset from " + path);
        // e.g., read CSV, images, etc.
    }

    protected void preprocess()
    {
        System.out.println("[Common] Splitting into train/test and normalizing");
    }

    protected abstract void train();
    protected abstract void evaluate();

    protected void save()
    {
        System.out.println("[Common] Saving model to disk as default format");
    }

    //Template Method
    public final void trainPipeline(String path)
    {
        loadData(path);
        preprocess();
        train();
        evaluate();
        save();
    }
}

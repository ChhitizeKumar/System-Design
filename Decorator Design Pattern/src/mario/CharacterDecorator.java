package mario;

public abstract class CharacterDecorator implements Character{

    protected Character character;

    CharacterDecorator(Character character)
    {
        this.character = character;
    }

    //Can be kept
//    @Override
//    public String getAbilities() {
//        return "";
//    }
}

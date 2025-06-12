package mario;

public class HeightUp extends CharacterDecorator{

    HeightUp(Character character) {
        super(character);
    }


    @Override
    public String getAbilities() {
        return character.getAbilities() + "with Height Up ";
    }
}

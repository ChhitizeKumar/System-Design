package mario;

public class StarPower extends CharacterDecorator{

    StarPower(Character character) {
        super(character);
    }

    @Override
    public String getAbilities() {
        return character.getAbilities() + "with Star Power ";
    }
}

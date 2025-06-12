package mario;

public class GunPower extends CharacterDecorator{

    public GunPower(Character character)
    {
        super(character);
    }

    @Override
    public String getAbilities() {
        return character.getAbilities() + "with Gun Power ";
    }
}

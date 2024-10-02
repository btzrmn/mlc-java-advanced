package football.core;

import football.entities.field.ArtificialTurf;
import football.entities.field.Field;
import football.entities.field.NaturalGrass;
import football.entities.player.Men;
import football.entities.player.Women;
import football.entities.supplement.Liquid;
import football.entities.supplement.Powdered;
import football.repositories.SupplementRepository;
import football.repositories.SupplementRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {

    private SupplementRepository supplement;
    private Collection<Field> fields;

    public ControllerImpl() {
        this.supplement = new SupplementRepositoryImpl();
        this.fields = new ArrayList<>();
    }

    @Override
    public String addField(String fieldType, String fieldName) {
        if (fieldType.equals("ArtificialTurf")) {
            ArtificialTurf artificialTurf = new ArtificialTurf(fieldName);
            this.fields.add(artificialTurf);
        } else {
            if (fieldType.equals("NaturalGrass")) {
                NaturalGrass naturalGrass = new NaturalGrass(fieldName);
                this.fields.add(naturalGrass);
            } else {
                throw new NullPointerException("Invalid field type.");
            }
        }
        return String.format("Successfully added %s.", fieldType);
    }

    @Override
    public String deliverySupplement(String type) {
        if (type.equals("Powdered")) {
            Powdered powdered = new Powdered();
            this.supplement.add(powdered);
        } else {
            if (type.equals("Liquid")) {
                Liquid liquid = new Liquid();
                this.supplement.add(liquid);
            } else {
                throw new IllegalArgumentException("Invalid supplement type.");
            }
        }
        return String.format("Successfully added %s.", type);
    }

    @Override
    public String supplementForField(String fieldName, String supplementType) {
        Field field = this.fields.stream().filter(f -> f.getName().equals(fieldName)).findFirst().orElse(null);
        if (field != null) {
            if (supplementType.equals("Powdered")) {
                Powdered powdered = new Powdered();
                field.addSupplement(powdered);
                return String.format("Successfully added %s to %s.", supplementType, fieldName);
            } else {
                if (supplementType.equals("Liquid")) {
                    Liquid liquid = new Liquid();
                    field.addSupplement(liquid);
                    return String.format("Successfully added %s to %s.", supplementType, fieldName);
                } else {
                    throw new IllegalArgumentException(String.format("There isn't a Supplement of type %s.", supplementType));
                }
            }
        } else {
            throw new IllegalArgumentException(String.format("There isn't a Supplement of type %s.", supplementType));
        }
    }

    @Override
    public String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength) {
        Field field = this.fields.stream().filter(f -> f.getName().equals(fieldName)).findFirst().orElse(null);
        if (field != null) {
            if (playerType.equals("Men")) {
                Men men = new Men(playerName, nationality, strength);
                field.addPlayer(men);
                return String.format("Successfully added %s to %s.", playerType, fieldName);
            } else if (playerType.equals("Women")) {
                Women women = new Women(playerName, nationality, strength);
                field.addPlayer(women);
                return String.format("Successfully added %s to %s.", playerType, fieldName);
            } else {
                return "Invalid player type.";
            }
        } else {
            return "The pavement of the terrain is not suitable.";
        }
    }

    @Override
    public String dragPlayer(String fieldName) {
        Field field = this.fields.stream().filter(f -> f.getName().equals(fieldName)).findFirst().orElse(null);
        if (field != null) {
            field.drag();
            return String.format("Player drag: %d", field.getPlayers().size());
        } else {
            return null;
        }
    }

    @Override
    public String calculateStrength(String fieldName) {
        Field field = this.fields.stream().filter(f -> f.getName().equals(fieldName)).findFirst().orElse(null);
        if (field != null) {
            int sum = field.getPlayers().stream().mapToInt(f -> f.getStrength()).sum();
            return String.format("The strength of Field %s is %d.", fieldName, sum);
        } else {
            return null;
        }
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (Field field : this.fields) {
            sb.append(field.getInfo()).append("\n");
        }
        return sb.toString();
    }
}

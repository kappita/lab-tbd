package Grupo6.VoluntariadoEmergencias.Forms;

import java.util.ArrayList;
import java.util.List;

public class AbilitiesForm {
    private String email;
    private List<Long> ability_ids;

    public AbilitiesForm(String email, List<Long> ability_ids) {
        this.email = email;
        this.ability_ids = ability_ids;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Long> getAbility_ids() {
        return ability_ids;
    }

    public void setAbility_ids(List<Long> ability_ids) {
        this.ability_ids = ability_ids;
    }
}

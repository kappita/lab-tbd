package Grupo6.VoluntariadoEmergencias.entities.Forms;

import java.util.ArrayList;
import java.util.List;

public class AbilitiesForm {
    private String token;
    private List<Long> ability_ids;

    public AbilitiesForm(String token, List<Long> ability_ids) {
        this.token = token;
        this.ability_ids = ability_ids;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<Long> getAbility_ids() {
        return ability_ids;
    }

    public void setAbility_ids(List<Long> ability_ids) {
        this.ability_ids = ability_ids;
    }
}

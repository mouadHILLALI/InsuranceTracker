package insurancetracker.insurancetracker.dtos;

import java.nio.file.Path;

public record ContractDto(Path justification , Object obj , double total) {
    public Path getJustification() {
        return justification;
    }
    public Object getObj() {
        return obj;
    }
    public double getTotal() {
        return total;
    }
}

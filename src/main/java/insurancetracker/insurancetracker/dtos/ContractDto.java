package insurancetracker.insurancetracker.dtos;

public record ContractDto(String justification , Object obj) {
    public String getJustification() {
        return justification;
    }
    public Object getObj() {
        return obj;
    }
}

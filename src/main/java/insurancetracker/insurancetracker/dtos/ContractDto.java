package insurancetracker.insurancetracker.dtos;


public record ContractDto(String justification , Object obj , double total) {
    public String getJustification() {
        return justification;
    }
    public Object getObj() {
        return obj;
    }
    public double getTotal() {
        return total;
    }
}

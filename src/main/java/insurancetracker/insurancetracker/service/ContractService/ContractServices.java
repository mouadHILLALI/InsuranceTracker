    package insurancetracker.insurancetracker.service.ContractService;

    import insurancetracker.insurancetracker.dtos.ContractDto;
    import insurancetracker.insurancetracker.model.*;
    import insurancetracker.insurancetracker.repository.ContractRepository;
    import jakarta.transaction.Transactional;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    @Service
    public class ContractServices {
        @Autowired
        private ContractRepository contractRepository;

        @Transactional
        public boolean addCarContract(ContractDto contractDto , AutoInsurance carInsurance , double total) {
            try {
                System.out.println("im here the id " + carInsurance.getPolicyNumber());
                Contract contract = new Contract(contractDto.justification() , carInsurance , total);
                contract = contractRepository.save(contract);
                if (contract != null) {
                    return true;
                }else{
                    return false;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

    }

package gov.iti.jets.sakila.soap.services;

import gov.iti.jets.sakila.persistence.dao.PaymentDao;
import gov.iti.jets.sakila.services.PaymentServices;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.modelmapper.ModelMapper;

@WebService
public class PaymentWebServices {
    PaymentServices paymentServices = new PaymentServices(new ModelMapper(), new PaymentDao());

    @WebMethod(operationName = "paymentOperationsNumByStaff")
    public Long countPaymentByStaffId(@WebParam(name = "staffId") int staffId) {
        return paymentServices.countPaymentByStaffId(staffId);
    }

    @WebMethod(operationName = "allPaymentAmountsByStaff")
    public Long countPaymentAmountByStaffId(@WebParam(name = "staffId") int staffId) {
        return paymentServices.countPaymentAmountByStaffId(staffId);
    }

    @WebMethod(operationName = "allPaymentAmountsByStaffPerMonth")
    public Long countPaymentAmountByStaffINdDate(@WebParam(name = "staffId") int staffId, @WebParam(name = "year") int year, @WebParam(name = "month") int month) {
        return paymentServices.countPaymentAmountByStaffINdDate(staffId, year, month);
    }

    @WebMethod(operationName = "allPaymentAmountsPaidByCustomer")
    public Long getCustomerPaymentOperationNum(@WebParam(name = "customerId") int customerId) {
        return paymentServices.getCustomerPaymentOperationNum(customerId);
    }

}

package molemo.quotejob.domain;

import android.app.AlertDialog;

import java.io.Serializable;

/**
 * Created by tsemol01 on 2015/12/03.
 */
public class AddJob implements Serializable {

    private Long id;
    private String customer;
    private String vehicle;
    private float price;
    private String jobName;

    private AddJob() {

    }

    public Long getId() {
        return id;
    }

    public String getCustomer()
    {
        return customer;
    }

    public String getVehicle()
    {
        return vehicle;
    }

    public float getPrice()
    {
        return  price;
    }

    public String getJobName()
    {
        return  jobName;
    }


    public AddJob(Builder builder) {
        id=builder.id;
        customer=builder.customer;
        vehicle=builder.vehicle;
        price=builder.price;
        jobName=builder.jobName;
    }

    public static class Builder {
        private Long id;
        private String customer;
        private String vehicle;
        private float price;
        private String jobName;


        public Builder(String customer)
        {
            this.customer=customer;
        }

        public Builder id(Long id)
        {
            this.id = id;
            return this;
        }

        public Builder vehicle(String  vehicle)
        {
            this.vehicle=vehicle;
            return  this;
        }

        public Builder price(float price)
        {
            this.price=price;
            return  this;
        }

        public Builder jobName(String jobName)
        {
            this.jobName=jobName;
            return  this;
        }

        public Builder copy(AddJob value) {
            this.id=value.getId();
            this.customer=value.getCustomer();
            this.jobName=value.getJobName();
            this.price=value.getPrice();
            this.vehicle=value.getVehicle();
            return this;
        }

        public AddJob build() {
            return new AddJob(this);
        }

    }
}

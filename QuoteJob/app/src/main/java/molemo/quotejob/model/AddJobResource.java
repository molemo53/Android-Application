package molemo.quotejob.model;


import org.springframework.hateoas.ResourceSupport;

/**
 * Created by tsemol01 on 2015/12/03.
 */
public class AddJobResource extends ResourceSupport {

    private Long resId;
    private String customer;
    private String vehicle;
    private float price;
    private String jobName;

    private  AddJobResource()
    {

    }

    public Long getResId(){return resId;}

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

    public AddJobResource(Builder builder) {
        resId=builder.resId;
        customer=builder.customer;
        vehicle=builder.vehicle;
        price=builder.price;
        jobName=builder.jobName;

    }
    public static class Builder{
        private Long resId;
        private String customer;
        private String vehicle;
        private float price;
        private String jobName;

        public Builder(String customer)
        {
            this.customer=customer;
        }


        public Builder resId(Long resId) {
            this.resId = resId;
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

        public Builder copy(AddJobResource value)
        {
            this.resId=value.getResId();
            this.customer=value.getCustomer();
            this.jobName=value.getJobName();
            this.price=value.getPrice();
            this.vehicle=value.getVehicle();
            return this;
        }

        public AddJobResource build()
        {
            return  new AddJobResource(this);
        }
    }
}
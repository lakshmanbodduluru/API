package admi.api;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Admin on 7/4/2016.
 */
public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.MyViewHolder> {
    Context context;
    ArrayList<Contacts> contactList;
    LayoutInflater inflater;

    public ContactAdapter(Context context, ArrayList<Contacts> contactList) {
        this.context = context;
        this.contactList = contactList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custome_layout_recycle_view, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Contacts contacts = contactList.get(position);
        holder.id.setText(contacts.getId());
        holder.name.setText(contacts.getName());
        holder.email.setText(contacts.getEmail());
        holder.address.setText(contacts.getAddress());
        holder.gender.setText(contacts.getGender());
        holder.mobile.setText(contacts.getMobile());
        holder.home.setText(contacts.getHome());
        holder.office.setText(contacts.getOffice());
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView id;
        TextView name;
        TextView email;
        TextView address;
        TextView gender;
        TextView mobile;
        TextView home;
        TextView office;

        public MyViewHolder(View view) {
            super(view);
            id = (TextView) view.findViewById(R.id.id_id);
            name = (TextView) view.findViewById(R.id.name);
            email = (TextView) view.findViewById(R.id.email);
            address = (TextView) view.findViewById(R.id.address);
            gender = (TextView) view.findViewById(R.id.gender);
            mobile = (TextView) view.findViewById(R.id.mobile);
            home = (TextView) view.findViewById(R.id.home);
            office = (TextView) view.findViewById(R.id.office);
        }
    }
}

package admi.api;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private final String TAG_CONTACT = "contacts";
    private static final String URL_ADDRESS = "http://api.androidhive.info/contacts/";
    private static final String TAG_ID = "id";
    private static final String TAG_NAME = "name";
    private static final String TAG_EMAIL = "email";
    private static final String TAG_ADDRESS = "address";
    private static final String TAG_GENDER = "gender";
    private static final String TAG_PHONE = "phone";
    private static final String TAG_MOBILE = "mobile";
    private static final String TAG_HOME = "home";
    private static final String TAG_OFFICE = "office";
    ArrayList<Contacts> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        MyClass myClass = new MyClass();
        myClass.execute(URL_ADDRESS);
    }

    private void init() {
        initViews();
        initListener();
    }

    private void initListener() {

    }

    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        contactList = new ArrayList<>();
    }


    public class MyClass extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.connect();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder builder = new StringBuilder();
                String data;
                while ((data = bufferedReader.readLine()) != null) {
                    builder.append(data).append("\n");
                }
                return builder.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            processJsonData(s);
        }
    }

    private void processJsonData(String s) {
        String home = "";
        String office = "";
        String mobile = "";
        if (s != null) {
            Toast.makeText(MainActivity.this, "Process JSON Data", Toast.LENGTH_SHORT).show();
            Log.e("processJsonData", "called");
            try {

                JSONObject jsonObject = new JSONObject(s);
                JSONArray contacts = jsonObject.getJSONArray(TAG_CONTACT);
                for (int i = 0; i < contacts.length(); i++) {
                    JSONObject contactsJSONObject = contacts.getJSONObject(i);
                    String id = contactsJSONObject.getString(TAG_ID);
                    String name = contactsJSONObject.getString(TAG_NAME);
                    String email = contactsJSONObject.getString(TAG_EMAIL);
                    String address = contactsJSONObject.getString(TAG_ADDRESS);
                    String gender = contactsJSONObject.getString(TAG_GENDER);
                    JSONObject phone = contactsJSONObject.getJSONObject(TAG_PHONE);
                    home = phone.getString(TAG_HOME);
                    mobile = phone.getString(TAG_MOBILE);
                    office = phone.getString(TAG_OFFICE);

                    Log.i("Values:", "id:" + id + "\n" + name + "\n" + email + "\n" + address + "\n" + home + "\n" + mobile + "\n" + office);

                    Contacts con = new Contacts();
                    con.setId(id);
                    con.setName(name);
                    con.setEmail(email);
                    con.setAddress(address);
                    con.setGender(gender);
                    con.setHome(home);
                    con.setMobile(mobile);
                    con.setOffice(office);
                    contactList.add(con);

                }
            } catch (JSONException e) {
                Log.e("Exception", ":" + e);
            }
            setAdapterForRecyclerView(contactList);
        } else {
            Toast.makeText(MainActivity.this, "Internet Problem", Toast.LENGTH_SHORT).show();
        }

    }

    private void setAdapterForRecyclerView(ArrayList<Contacts> contactList) {
        if (contactList.size() != 0) {
            ContactAdapter contactAdapter = new ContactAdapter(getApplicationContext(), contactList);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(contactAdapter);
        }
        else {
            Toast.makeText(MainActivity.this, "No Contacts to Display", Toast.LENGTH_SHORT).show();
        }

    }

}

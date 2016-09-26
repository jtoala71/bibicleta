package com.asovel.bibicleta.Comunicacion_base_datos.BackendlessCRUD.start;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.backendless.Backendless;
import com.asovel.bibicleta.R;
import com.asovel.bibicleta.Comunicacion_base_datos.BackendlessCRUD.common.DataApplication;
import com.asovel.bibicleta.Comunicacion_base_datos.BackendlessCRUD.common.Defaults;

public class SelectTableActivity extends Activity
{
  private ListView tablesListView;

  public void onCreate( Bundle savedInstanceState )
  {
    super.onCreate( savedInstanceState );
    setContentView( R.layout.select_table );

    Backendless.setUrl( Defaults.SERVER_URL );
    Backendless.initApp( getBaseContext(), Defaults.APPLICATION_ID, Defaults.SECRET_KEY, Defaults.VERSION );

    initUI();
  }

  private void initUI()
  {
    tablesListView = (ListView) findViewById( R.id.tablesList );

    String[] tables = new String[] { "marca", "eBike", "tiendas", "fabricante" };

    ArrayAdapter adapter = new ArrayAdapter<String>( this, R.layout.list_item_with_arrow, R.id.itemName, tables );
    tablesListView.setAdapter( adapter );

    tablesListView.setOnItemClickListener( new AdapterView.OnItemClickListener()
    {
      @Override
      public void onItemClick( AdapterView<?> adapterView, View view, int i, long l )
      {
        TextView tableNameView = (TextView) view.findViewById( R.id.itemName );
        DataApplication dataApplication = (DataApplication) getApplication();
        dataApplication.setChosenTable( tableNameView.getText().toString() );

         // Log.i(tableNameView.getText().toString());



        startActivity( new Intent( SelectTableActivity.this, SelectTableOperationActivity.class ) );
      }
    } );
  }
}
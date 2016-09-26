package com.asovel.bibicleta.Comunicacion_base_datos.BackendlessCRUD.retrieve;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.asovel.bibicleta.R;
import com.asovel.bibicleta.Comunicacion_base_datos.BackendlessCRUD.common.DataApplication;

import java.util.ArrayList;

public class SelectRetrievalTypeActivity extends Activity
{
  private TextView titleView;
  private ListView retrieveOptionsView;

  private String table;
  private String[] properties;
  private String[] relations;
  private String[] relatedTables;

  public void onCreate( Bundle savedInstanceState )
  {
    super.onCreate( savedInstanceState );
    setContentView( R.layout.select_retrieval_type );

    DataApplication dataApplication = (DataApplication) getApplication();
    table = dataApplication.getChosenTable();

    initUI();
  }

  private void initUI()
  {
    titleView = (TextView) findViewById( R.id.retrieveTitle );
    retrieveOptionsView = (ListView) findViewById( R.id.retrieveOptionsList );

    String titleTemplate = getResources().getString( R.string.retrieve_title_template );
    String title = String.format( titleTemplate, table );
    titleView.setText( title );

    String[] retrieveOptions = getResources().getStringArray( R.array.retrieve_options );
    ArrayAdapter adapter = new ArrayAdapter( getBaseContext(), R.layout.list_item_with_arrow, R.id.itemName, retrieveOptions );
    retrieveOptionsView.setAdapter( adapter );

    retrieveOptionsView.setOnItemClickListener( new AdapterView.OnItemClickListener()
    {
      @Override
      public void onItemClick( AdapterView<?> adapterView, View view, int i, long l )
      {
        TextView selectedItemView = (TextView) view.findViewById( R.id.itemName );
        String option = selectedItemView.getText().toString();
        onOptionChosen( option );
      }
    } );
  }

  private void onOptionChosen( String option )
  {
    final Intent nextIntent = new Intent( this, RetrieveRecordActivity.class );
    nextIntent.putExtra( "type", option );

    if( option.equals( "Find with Sort" ) )
    {
      AlertDialog.Builder builder = new AlertDialog.Builder( this );
      builder.setTitle( "Properties to sort by:" );
      final ArrayList<CharSequence> selectedItems = new ArrayList<CharSequence>();

      if( table.equals( "marca" ) )
      {
        properties = new String[] { "updated", "tipo_de_via", "email", "ownerId", "objectId", "codigo_postal", "pagina_web", "telefono", "numero", "pais", "nombre_marca", "ciudad", "logo", "direccion", "created" };
      }
      else if( table.equals( "eBike" ) )
      {
        properties = new String[] { "suspension", "tipo_sensor", "created", "tipo_de_uso", "tipo_cuadro", "precio", "ubicacion_motor", "puntos_de_venta", "peso_total", "material_del_cuadro", "velocidades", "tipo_display", "foto", "autonomia", "pagina_web", "ownerId", "modelo", "objectId", "tamano_ruedas", "updated" };
      }
      else if( table.equals( "tiendas" ) )
      {
        properties = new String[] { "objectId", "nombre", "ciudad", "pais", "tipo_de_via", "pagina_web", "created", "updated", "codigo_postal", "email", "telefono", "nombre_fabricante", "latitud", "numero", "direccion", "longitud", "ownerId" };
      }
      else if( table.equals( "fabricante" ) )
      {
        properties = new String[] { "codigo_postal", "ownerId", "ciudad", "objectId", "pais", "updated", "email", "nombre_fabricante", "created", "numero", "telefono", "tipo_de_via", "direccion", "pagina_web" };
      }

      builder.setMultiChoiceItems( properties, null, new DialogInterface.OnMultiChoiceClickListener()
      {
        @Override
        public void onClick( DialogInterface dialogInterface, int which, boolean isChecked )
        {
          if( isChecked )
          {
            selectedItems.add( properties[ which ] );
          }
          else if( selectedItems.contains( properties[ which ] ) )
          {
            selectedItems.remove( properties[ which ] );
          }
        }
      } );

      builder.setPositiveButton( "Find", new DialogInterface.OnClickListener()
      {
        @Override
        public void onClick( DialogInterface dialogInterface, int i )
        {
          nextIntent.putCharSequenceArrayListExtra( "selectedProperties", selectedItems );
          startActivity( nextIntent );
        }
      } );

      builder.create().show();
    }
    else if( option.equals( "Find with Relations" ) )
    {
      AlertDialog.Builder builder = new AlertDialog.Builder( this );
      builder.setTitle( "Relations to preload:" );
      final ArrayList<CharSequence> selectedRelations = new ArrayList<CharSequence>();
      final ArrayList<CharSequence> selectedRelatedTables = new ArrayList<CharSequence>();

      if( table.equals( "marca" ) )
      {
        relations = new String[] { "modelo_eBike", "nombre_fabricante" };
        relatedTables = new String[] { "eBike", "fabricante" };
      }
      else if( table.equals( "eBike" ) )
      {
        relations = new String[] { "marca" };
        relatedTables = new String[] { "tiendas" };
      }
      else if( table.equals( "tiendas" ) )
      {
        relations = new String[] {  };
        relatedTables = new String[] {  };
      }
      else if( table.equals( "fabricante" ) )
      {
        relations = new String[] {  };
        relatedTables = new String[] {  };
      }

      builder.setMultiChoiceItems( relations, null, new DialogInterface.OnMultiChoiceClickListener()
      {
        @Override
        public void onClick( DialogInterface dialogInterface, int which, boolean isChecked )
        {
          if( isChecked )
          {
            selectedRelations.add( relations[ which ] );
            selectedRelatedTables.add( relatedTables[ which ] );
          }
          else if( selectedRelations.contains( relations[ which ] ) )
          {
            selectedRelations.remove( relations[ which ] );
            selectedRelatedTables.remove( relatedTables[ which ] );
          }
        }
      } );

      builder.setPositiveButton( "Find", new DialogInterface.OnClickListener()
      {
        @Override
        public void onClick( DialogInterface dialogInterface, int i )
        {
          nextIntent.putCharSequenceArrayListExtra( "selectedRelations", selectedRelations );
          nextIntent.putCharSequenceArrayListExtra( "selectedRelatedTables", selectedRelatedTables );
          startActivity( nextIntent );
        }
      } );

      builder.create().show();
    }
    else
    {
      startActivity( nextIntent );
    }
  }
}
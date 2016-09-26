package com.asovel.bibicleta.Comunicacion_base_datos.BackendlessCRUD.retrieve;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.backendless.BackendlessCollection;
import com.asovel.bibicleta.Comunicacion_base_datos.BackendlessData.*;
import com.asovel.bibicleta.R;
import com.asovel.bibicleta.Comunicacion_base_datos.BackendlessCRUD.common.DataApplication;
import com.asovel.bibicleta.Comunicacion_base_datos.BackendlessCRUD.common.DefaultCallback;
import com.asovel.bibicleta.Comunicacion_base_datos.BackendlessCRUD.common.SendEmailActivity;
import com.backendless.persistence.BackendlessDataQuery;
import com.backendless.persistence.QueryOptions;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class RetrieveRecordActivity extends Activity
{
  private TextView titleView;
  private EditText codeView;
  private Button runCodeButton, sendCodeButton;

  private String code;
  private String table;
  private String type;

  private static BackendlessCollection resultCollection;
  private static Object resultObject;

  private String selectedProperty;
  private String selectedRelatedTable;
  private String selectedRelatedProperty;
  private String relation;
  private String[] relatedProperties;

  public static BackendlessCollection getResultCollection()
  {
    return resultCollection;
  }

  public static Object getResultObject()
  {
    return resultObject;
  }

  public void onCreate( Bundle savedInstanceState )
  {
    super.onCreate( savedInstanceState );
    setContentView( R.layout.sample_code_template );

    DataApplication dataApplication = (DataApplication) getApplication();
    table = dataApplication.getChosenTable();

    type = getIntent().getStringExtra( "type" );

    initUI();
  }

  private void initUI()
  {
    titleView = (TextView) findViewById( R.id.sampleCodeTitle );
    codeView = (EditText) findViewById( R.id.sampleCodeEdit );
    runCodeButton = (Button) findViewById( R.id.runCodeButton );
    sendCodeButton = (Button) findViewById( R.id.sendCodeButton );

    String titleTemplate = getResources().getString( R.string.retrieve_title_template );
    String title = String.format( titleTemplate, table );
    titleView.setText( title );
    if( table.equals( "marca" ) )
    {
      code = getMarcaRetrievalCode();
    }
    else if( table.equals( "eBike" ) )
    {
      code = getEBikeRetrievalCode();
    }
    else if( table.equals( "tiendas" ) )
    {
      code = getTiendasRetrievalCode();
    }
    else if( table.equals( "fabricante" ) )
    {
      code = getFabricanteRetrievalCode();
    }

    codeView.setText( code );

    runCodeButton.setOnClickListener( new View.OnClickListener()
    {
      @Override
      public void onClick( View view )
      {
        onRunCodeButtonClicked();
      }
    } );

    sendCodeButton.setOnClickListener( new View.OnClickListener()
    {
      @Override
      public void onClick( View view )
      {
        onSendCodeButtonClicked();
      }
    } );
  }

  private void onRunCodeButtonClicked()
  {
    if( table.equals( "marca" ) )
    {
      retrieveMarcaRecord();
    }
    else if( table.equals( "eBike" ) )
    {
      retrieveEBikeRecord();
    }
    else if( table.equals( "tiendas" ) )
    {
      retrieveTiendasRecord();
    }
    else if( table.equals( "fabricante" ) )
    {
      retrieveFabricanteRecord();
    }
  }

  private void onSendCodeButtonClicked()
  {
    Intent nextIntent = new Intent( getBaseContext(), SendEmailActivity.class );
    nextIntent.putExtra( "code", code );
    nextIntent.putExtra( "table", table );
    nextIntent.putExtra( "method", type );
    startActivity( nextIntent );
  }
                                                        
  private String getMarcaRetrievalCode()
  {
    if( type.equals( "Basic Find" ) )
    {
      return getBasicMarcaRetrievalCode();
    }
    else if( type.equals( "Find First" ) )
    {
      return getFirstMarcaRetrievalCode();
    }
    else if( type.equals( "Find Last" ) )
    {
      return getLastMarcaRetrievalCode();
    }
    else if( type.equals( "Find with Sort" ) )
    {
      return getSortedMarcaRetrievalCode();
    }
    else if( type.equals( "Find with Relations" ) )
    {
      return getRelatedMarcaRetrievalCode();
    }
    return null;
  }

  private void retrieveMarcaRecord()
  {
    if( type.equals( "Basic Find" ) )
    {
      retrieveBasicMarcaRecord();
    }
    else if( type.equals( "Find First" ) )
    {
      retrieveFirstMarcaRecord();
    }
    else if( type.equals( "Find Last" ) )
    {
      retrieveLastMarcaRecord();
    }
    else if( type.equals( "Find with Sort" ) )
    {
      retrieveSortedMarcaRecord();
    }
    else if( type.equals( "Find with Relations" ) )
    {
      retrieveRelatedMarcaRecord();
    }
  }

  private String getBasicMarcaRetrievalCode()
  {
    return "BackendlessDataQuery query = new BackendlessDataQuery();\n"
            + "marca.findAsync( query, new AsyncCallback<BackendlessCollection<marca>>()\n"
            + "{\n"
            + "  @Override\n"
            + "  public void handleResponse( BackendlessCollection<marca> response )\n"
            + "  {\n"
            + "    marca firstMarca = response.getCurrentPage().get( 0 );\n"
            + "  }\n"
            + "  @Override\n"
            + "  public void handleFault( BackendlessFault fault )\n"
            + "  {\n"
            + "    Toast.makeText( getBaseContext(), fault.getMessage(), Toast.LENGTH_SHORT ).show();\n"
            + "  }\n"
            + "} );";
  }

  private void retrieveBasicMarcaRecord()
  {
    BackendlessDataQuery query = new BackendlessDataQuery();
    marca.findAsync( query, new DefaultCallback<BackendlessCollection<marca>>( RetrieveRecordActivity.this )
    {
      @Override
      public void handleResponse( BackendlessCollection<marca> response )
      {
        super.handleResponse( response );

        resultCollection = response;

        AlertDialog.Builder builder = new AlertDialog.Builder( RetrieveRecordActivity.this );
        builder.setTitle( "Property to show:" );
        final String[] properties = { "updated", "tipo_de_via", "email", "ownerId", "objectId", "codigo_postal", "pagina_web", "telefono", "numero", "pais", "nombre_marca", "ciudad", "logo", "direccion", "created" };
        builder.setItems( properties, new DialogInterface.OnClickListener()
        {
          @Override
          public void onClick( DialogInterface dialogInterface, int i )
          {
            Intent nextIntent = new Intent( RetrieveRecordActivity.this, ShowByPropertyActivity.class );
            nextIntent.putExtra( "type", type );
            nextIntent.putExtra( "property", properties[ i ] );
            startActivity( nextIntent );
            dialogInterface.cancel();
          }
        } );
        builder.create().show();
      }
    } );
  }

  private String getFirstMarcaRetrievalCode()
  {
    return "marca.findFirstAsync( new AsyncCallback<marca>()\n"
            + "{\n"
            + "  @Override\n"
            + "  public void handleResponse( marca object )\n"
            + "  {\n"
            + "    //work with the object\n"
            + "  }\n"
            + "  @Override\n"
            + "  public void handleFault( BackendlessFault fault )\n"
            + "  {\n"
            + "    Toast.makeText( getBaseContext(), fault.getMessage(), Toast.LENGTH_SHORT ).show();\n"
            + "  }\n"
            + "} );";
  }

  private void retrieveFirstMarcaRecord()
  {
    marca.findFirstAsync( new DefaultCallback<marca>( RetrieveRecordActivity.this )
    {
      @Override
      public void handleResponse( marca response )
      {
        super.handleResponse( response );
        resultObject = response;
        Intent nextIntent = new Intent( RetrieveRecordActivity.this, ShowEntityActivity.class );
        nextIntent.putExtra( "type", type );
        startActivity( nextIntent );
      }
    } );
  }

  private String getLastMarcaRetrievalCode()
  {
    return "marca.findLastAsync( new AsyncCallback<marca>()\n"
            + "{\n"
            + "  @Override\n"
            + "  public void handleResponse( marca object )\n"
            + "  {\n"
            + "    //work with the object\n"
            + "  }\n"
            + "  @Override\n"
            + "  public void handleFault( BackendlessFault fault )\n"
            + "  {\n"
            + "    Toast.makeText( getBaseContext(), fault.getMessage(), Toast.LENGTH_SHORT ).show();\n"
            + "  }\n"
            + "} );";
  }

  private void retrieveLastMarcaRecord()
  {
    marca.findLastAsync( new DefaultCallback<marca>( RetrieveRecordActivity.this )
    {
      @Override
      public void handleResponse( marca response )
      {
        super.handleResponse( response );
        resultObject = response;
        Intent nextIntent = new Intent( RetrieveRecordActivity.this, ShowEntityActivity.class );
        nextIntent.putExtra( "type", type );
        startActivity( nextIntent );
      }
    } );
  }

  private String getSortedMarcaRetrievalCode()
  {
    return "QueryOptions queryOptions = new QueryOptions();\n"
            + "List<String> sortByProperties = new ArrayList<String>();\n"
            + "sortByProperties.add( \"someProperty\" );\n"
            + "queryOptions.setSortBy( sortByProperties );\n"
            + "BackendlessDataQuery query = new BackendlessDataQuery(  );\n"
            + "query.setQueryOptions( queryOptions );\n"
            + "marca.findAsync( query, new AsyncCallback<BackendlessCollection<marca>>()\n"
            + "{\n"
            + "  @Override\n"
            + "  public void handleResponse( BackendlessCollection<marca> response )\n"
            + "  {\n"
            + "    marca firstSortedMarca = response.getCurrentPage().get( 0 );\n"
            + "  }\n"
            + "  @Override\n"
            + "  public void handleFault( BackendlessFault fault )\n"
            + "  {\n"
            + "    Toast.makeText( getBaseContext(), fault.getMessage(), Toast.LENGTH_SHORT ).show();\n"
            + "  }\n"
            + "} );";
  }

  private void retrieveSortedMarcaRecord()
  {
    List<CharSequence> selectedItems = getIntent().getCharSequenceArrayListExtra( "selectedProperties" );
    QueryOptions queryOptions = new QueryOptions();
    List<String> sortByProperties = Arrays.asList( selectedItems.toArray( new String[ selectedItems.size() ] ) );
    queryOptions.setSortBy( sortByProperties );
    BackendlessDataQuery query = new BackendlessDataQuery();
    query.setQueryOptions( queryOptions );
    marca.findAsync( query, new DefaultCallback<BackendlessCollection<marca>>( RetrieveRecordActivity.this )
    {
      @Override
      public void handleResponse( BackendlessCollection<marca> response )
      {
        super.handleResponse( response );

        resultCollection = response;

        AlertDialog.Builder builder = new AlertDialog.Builder( RetrieveRecordActivity.this );
        builder.setTitle( "Property to show:" );
        final String[] properties = { "updated", "tipo_de_via", "email", "ownerId", "objectId", "codigo_postal", "pagina_web", "telefono", "numero", "pais", "nombre_marca", "ciudad", "logo", "direccion", "created" };
        builder.setItems( properties, new DialogInterface.OnClickListener()
        {
          @Override
          public void onClick( DialogInterface dialogInterface, int i )
          {
            Intent nextIntent = new Intent( RetrieveRecordActivity.this, ShowByPropertyActivity.class );
            nextIntent.putExtra( "type", type );
            nextIntent.putExtra( "property", properties[ i ] );
            startActivity( nextIntent );
            dialogInterface.cancel();
          }
        } );
        builder.create().show();
      }
    } );
  }

  private String getRelatedMarcaRetrievalCode()
  {
    return "QueryOptions queryOptions = new QueryOptions();\n"
            + "List<String> relationsToFind = new ArrayList<String>();\n"
            + "relationsToFind.add( \"modelo_eBike\" )\n"
            + "relationsToFind.add( \"nombre_fabricante\" )\n"
            + "queryOptions.setRelated( relationsToFind );\n"
            + "BackendlessDataQuery query = new BackendlessDataQuery();\n"
            + "query.setQueryOptions( queryOptions );\n"
            + "marca.findAsync( query, new AsyncCallback<BackendlessCollection<marca>>()\n"
            + "{\n"
            + "  @Override\n"
            + "  public void handleResponse( BackendlessCollection<marca> collection )\n"
            + "  {\n"
            + "    //work with objects\n"
            + "  }\n"
            + "  public void handleFault( BackendlessFault fault )\n"
            + "  {\n"
            + "    Toast.makeText( getBaseContext(), fault.getMessage(), Toast.LENGTH_SHORT ).show();\n"
            + "  }\n"
            + "}";
  }

  private void retrieveRelatedMarcaRecord()
  {
    final List<CharSequence> selectedRelations = getIntent().getCharSequenceArrayListExtra( "selectedRelations" );
    final List<CharSequence> selectedRelatedTables = getIntent().getCharSequenceArrayListExtra( "selectedRelatedTables" );
    final String[] selectedRelationsArray = selectedRelations.toArray( new String[ selectedRelations.size() ] );
    final String[] selectedRelatedTablesArray = selectedRelatedTables.toArray( new String[ selectedRelatedTables.size() ] );
    QueryOptions queryOptions = new QueryOptions();
    List<String> relationsToFind = Arrays.asList( selectedRelationsArray );
    queryOptions.setRelated( relationsToFind );
    BackendlessDataQuery query = new BackendlessDataQuery();
    query.setQueryOptions( queryOptions );
    marca.findAsync( query, new DefaultCallback<BackendlessCollection<marca>>( RetrieveRecordActivity.this )
    {
      @Override
      public void handleResponse( BackendlessCollection<marca> response )
      {
        super.handleResponse( response );
        resultCollection = response;

        AlertDialog.Builder builder = new AlertDialog.Builder( RetrieveRecordActivity.this );
        builder.setTitle( "Property to show:" );
        final String[] properties = { "updated", "tipo_de_via", "email", "ownerId", "objectId", "codigo_postal", "pagina_web", "telefono", "numero", "pais", "nombre_marca", "ciudad", "logo", "direccion", "created" };
        builder.setItems( properties, new DialogInterface.OnClickListener()
        {
          @Override
          public void onClick( DialogInterface dialogInterface, int i )
          {
            selectedProperty = properties[ i ];

            AlertDialog.Builder builder = new AlertDialog.Builder( RetrieveRecordActivity.this );
            builder.setTitle( "Related table to show:" );
            builder.setItems( selectedRelatedTablesArray, new DialogInterface.OnClickListener()
            {
              @Override
              public void onClick( DialogInterface dialogInterface, int i )
              {
                selectedRelatedTable = selectedRelatedTablesArray[ i ];
                relation = selectedRelationsArray[ i ];
                if( selectedRelatedTable.equals( "GeoPoint" ) )
                {
                  relatedProperties = new String[] { "Latitude", "Longitude", "Metadata" };
                }
                dialogInterface.cancel();

                AlertDialog.Builder builder = new AlertDialog.Builder( RetrieveRecordActivity.this );
                builder.setTitle( "Related property to show:" );
                if( selectedRelatedTable.equals( "marca" ) )
                {
                  relatedProperties = new String[] { "updated", "tipo_de_via", "email", "ownerId", "objectId", "codigo_postal", "pagina_web", "telefono", "numero", "pais", "nombre_marca", "ciudad", "logo", "direccion", "created" };
                }
                else if( selectedRelatedTable.equals( "eBike" ) )
                {
                  relatedProperties = new String[] { "suspension", "tipo_sensor", "created", "tipo_de_uso", "tipo_cuadro", "precio", "ubicacion_motor", "puntos_de_venta", "peso_total", "material_del_cuadro", "velocidades", "tipo_display", "foto", "autonomia", "pagina_web", "ownerId", "modelo", "objectId", "tamano_ruedas", "updated" };
                }
                else if( selectedRelatedTable.equals( "tiendas" ) )
                {
                  relatedProperties = new String[] { "objectId", "nombre", "ciudad", "pais", "tipo_de_via", "pagina_web", "created", "updated", "codigo_postal", "email", "telefono", "nombre_fabricante", "latitud", "numero", "direccion", "longitud", "ownerId" };
                }
                else if( selectedRelatedTable.equals( "fabricante" ) )
                {
                  relatedProperties = new String[] { "codigo_postal", "ownerId", "ciudad", "objectId", "pais", "updated", "email", "nombre_fabricante", "created", "numero", "telefono", "tipo_de_via", "direccion", "pagina_web" };
                }

                builder.setItems( relatedProperties, new DialogInterface.OnClickListener()
                {
                  @Override
                  public void onClick( DialogInterface dialogInterface, int i )
                  {
                    selectedRelatedProperty = relatedProperties[ i ];
                    dialogInterface.cancel();
                    Intent nextIntent = new Intent( RetrieveRecordActivity.this, ShowEntityActivity.class );
                    nextIntent.putExtra( "type", type );
                    nextIntent.putExtra( "property", selectedProperty );
                    nextIntent.putExtra( "relation", relation );
                    nextIntent.putExtra( "relatedTable", selectedRelatedTable );
                    nextIntent.putExtra( "relatedProperty", selectedRelatedProperty );
                    startActivity( nextIntent );
                    dialogInterface.cancel();
                  }
                } );
                builder.create().show();
              }
            } );
            builder.create().show();
          }
        } );
        builder.create().show();
      }
    } );
  }

  private String getEBikeRetrievalCode()
  {
    if( type.equals( "Basic Find" ) )
    {
      return getBasicEBikeRetrievalCode();
    }
    else if( type.equals( "Find First" ) )
    {
      return getFirstEBikeRetrievalCode();
    }
    else if( type.equals( "Find Last" ) )
    {
      return getLastEBikeRetrievalCode();
    }
    else if( type.equals( "Find with Sort" ) )
    {
      return getSortedEBikeRetrievalCode();
    }
    else if( type.equals( "Find with Relations" ) )
    {
      return getRelatedEBikeRetrievalCode();
    }
    return null;
  }

  private void retrieveEBikeRecord()
  {
    if( type.equals( "Basic Find" ) )
    {
      retrieveBasicEBikeRecord();
    }
    else if( type.equals( "Find First" ) )
    {
      retrieveFirstEBikeRecord();
    }
    else if( type.equals( "Find Last" ) )
    {
      retrieveLastEBikeRecord();
    }
    else if( type.equals( "Find with Sort" ) )
    {
      retrieveSortedEBikeRecord();
    }
    else if( type.equals( "Find with Relations" ) )
    {
      retrieveRelatedEBikeRecord();
    }
  }

  private String getBasicEBikeRetrievalCode()
  {
    return "BackendlessDataQuery query = new BackendlessDataQuery();\n"
            + "eBike.findAsync( query, new AsyncCallback<BackendlessCollection<eBike>>()\n"
            + "{\n"
            + "  @Override\n"
            + "  public void handleResponse( BackendlessCollection<eBike> response )\n"
            + "  {\n"
            + "    eBike firstEBike = response.getCurrentPage().get( 0 );\n"
            + "  }\n"
            + "  @Override\n"
            + "  public void handleFault( BackendlessFault fault )\n"
            + "  {\n"
            + "    Toast.makeText( getBaseContext(), fault.getMessage(), Toast.LENGTH_SHORT ).show();\n"
            + "  }\n"
            + "} );";
  }

  private void retrieveBasicEBikeRecord()
  {
    BackendlessDataQuery query = new BackendlessDataQuery();
    eBike.findAsync( query, new DefaultCallback<BackendlessCollection<eBike>>( RetrieveRecordActivity.this )
    {
      @Override
      public void handleResponse( BackendlessCollection<eBike> response )
      {
        super.handleResponse( response );

        resultCollection = response;

        AlertDialog.Builder builder = new AlertDialog.Builder( RetrieveRecordActivity.this );
        builder.setTitle( "Property to show:" );
        final String[] properties = { "suspension", "tipo_sensor", "created", "tipo_de_uso", "tipo_cuadro", "precio", "ubicacion_motor", "puntos_de_venta", "peso_total", "material_del_cuadro", "velocidades", "tipo_display", "foto", "autonomia", "pagina_web", "ownerId", "modelo", "objectId", "tamano_ruedas", "updated" };
        builder.setItems( properties, new DialogInterface.OnClickListener()
        {
          @Override
          public void onClick( DialogInterface dialogInterface, int i )
          {
            Intent nextIntent = new Intent( RetrieveRecordActivity.this, ShowByPropertyActivity.class );
            nextIntent.putExtra( "type", type );
            nextIntent.putExtra( "property", properties[ i ] );
            startActivity( nextIntent );
            dialogInterface.cancel();
          }
        } );
        builder.create().show();
      }
    } );
  }

  private String getFirstEBikeRetrievalCode()
  {
    return "eBike.findFirstAsync( new AsyncCallback<eBike>()\n"
            + "{\n"
            + "  @Override\n"
            + "  public void handleResponse( eBike object )\n"
            + "  {\n"
            + "    //work with the object\n"
            + "  }\n"
            + "  @Override\n"
            + "  public void handleFault( BackendlessFault fault )\n"
            + "  {\n"
            + "    Toast.makeText( getBaseContext(), fault.getMessage(), Toast.LENGTH_SHORT ).show();\n"
            + "  }\n"
            + "} );";
  }

  private void retrieveFirstEBikeRecord()
  {
    eBike.findFirstAsync( new DefaultCallback<eBike>( RetrieveRecordActivity.this )
    {
      @Override
      public void handleResponse( eBike response )
      {
        super.handleResponse( response );
        resultObject = response;
        Intent nextIntent = new Intent( RetrieveRecordActivity.this, ShowEntityActivity.class );
        nextIntent.putExtra( "type", type );
        startActivity( nextIntent );
      }
    } );
  }

  private String getLastEBikeRetrievalCode()
  {
    return "eBike.findLastAsync( new AsyncCallback<eBike>()\n"
            + "{\n"
            + "  @Override\n"
            + "  public void handleResponse( eBike object )\n"
            + "  {\n"
            + "    //work with the object\n"
            + "  }\n"
            + "  @Override\n"
            + "  public void handleFault( BackendlessFault fault )\n"
            + "  {\n"
            + "    Toast.makeText( getBaseContext(), fault.getMessage(), Toast.LENGTH_SHORT ).show();\n"
            + "  }\n"
            + "} );";
  }

  private void retrieveLastEBikeRecord()
  {
    eBike.findLastAsync( new DefaultCallback<eBike>( RetrieveRecordActivity.this )
    {
      @Override
      public void handleResponse( eBike response )
      {
        super.handleResponse( response );
        resultObject = response;
        Intent nextIntent = new Intent( RetrieveRecordActivity.this, ShowEntityActivity.class );
        nextIntent.putExtra( "type", type );
        startActivity( nextIntent );
      }
    } );
  }

  private String getSortedEBikeRetrievalCode()
  {
    return "QueryOptions queryOptions = new QueryOptions();\n"
            + "List<String> sortByProperties = new ArrayList<String>();\n"
            + "sortByProperties.add( \"someProperty\" );\n"
            + "queryOptions.setSortBy( sortByProperties );\n"
            + "BackendlessDataQuery query = new BackendlessDataQuery(  );\n"
            + "query.setQueryOptions( queryOptions );\n"
            + "eBike.findAsync( query, new AsyncCallback<BackendlessCollection<eBike>>()\n"
            + "{\n"
            + "  @Override\n"
            + "  public void handleResponse( BackendlessCollection<eBike> response )\n"
            + "  {\n"
            + "    eBike firstSortedEBike = response.getCurrentPage().get( 0 );\n"
            + "  }\n"
            + "  @Override\n"
            + "  public void handleFault( BackendlessFault fault )\n"
            + "  {\n"
            + "    Toast.makeText( getBaseContext(), fault.getMessage(), Toast.LENGTH_SHORT ).show();\n"
            + "  }\n"
            + "} );";
  }

  private void retrieveSortedEBikeRecord()
  {
    List<CharSequence> selectedItems = getIntent().getCharSequenceArrayListExtra( "selectedProperties" );
    QueryOptions queryOptions = new QueryOptions();
    List<String> sortByProperties = Arrays.asList( selectedItems.toArray( new String[ selectedItems.size() ] ) );
    queryOptions.setSortBy( sortByProperties );
    BackendlessDataQuery query = new BackendlessDataQuery();
    query.setQueryOptions( queryOptions );
    eBike.findAsync( query, new DefaultCallback<BackendlessCollection<eBike>>( RetrieveRecordActivity.this )
    {
      @Override
      public void handleResponse( BackendlessCollection<eBike> response )
      {
        super.handleResponse( response );

        resultCollection = response;

        AlertDialog.Builder builder = new AlertDialog.Builder( RetrieveRecordActivity.this );
        builder.setTitle( "Property to show:" );
        final String[] properties = { "suspension", "tipo_sensor", "created", "tipo_de_uso", "tipo_cuadro", "precio", "ubicacion_motor", "puntos_de_venta", "peso_total", "material_del_cuadro", "velocidades", "tipo_display", "foto", "autonomia", "pagina_web", "ownerId", "modelo", "objectId", "tamano_ruedas", "updated" };
        builder.setItems( properties, new DialogInterface.OnClickListener()
        {
          @Override
          public void onClick( DialogInterface dialogInterface, int i )
          {
            Intent nextIntent = new Intent( RetrieveRecordActivity.this, ShowByPropertyActivity.class );
            nextIntent.putExtra( "type", type );
            nextIntent.putExtra( "property", properties[ i ] );
            startActivity( nextIntent );
            dialogInterface.cancel();
          }
        } );
        builder.create().show();
      }
    } );
  }

  private String getRelatedEBikeRetrievalCode()
  {
    return "QueryOptions queryOptions = new QueryOptions();\n"
            + "List<String> relationsToFind = new ArrayList<String>();\n"
            + "relationsToFind.add( \"marca\" )\n"
            + "queryOptions.setRelated( relationsToFind );\n"
            + "BackendlessDataQuery query = new BackendlessDataQuery();\n"
            + "query.setQueryOptions( queryOptions );\n"
            + "eBike.findAsync( query, new AsyncCallback<BackendlessCollection<eBike>>()\n"
            + "{\n"
            + "  @Override\n"
            + "  public void handleResponse( BackendlessCollection<eBike> collection )\n"
            + "  {\n"
            + "    //work with objects\n"
            + "  }\n"
            + "  public void handleFault( BackendlessFault fault )\n"
            + "  {\n"
            + "    Toast.makeText( getBaseContext(), fault.getMessage(), Toast.LENGTH_SHORT ).show();\n"
            + "  }\n"
            + "}";
  }

  private void retrieveRelatedEBikeRecord()
  {
    final List<CharSequence> selectedRelations = getIntent().getCharSequenceArrayListExtra( "selectedRelations" );
    final List<CharSequence> selectedRelatedTables = getIntent().getCharSequenceArrayListExtra( "selectedRelatedTables" );
    final String[] selectedRelationsArray = selectedRelations.toArray( new String[ selectedRelations.size() ] );
    final String[] selectedRelatedTablesArray = selectedRelatedTables.toArray( new String[ selectedRelatedTables.size() ] );
    QueryOptions queryOptions = new QueryOptions();
    List<String> relationsToFind = Arrays.asList( selectedRelationsArray );
    queryOptions.setRelated( relationsToFind );
    BackendlessDataQuery query = new BackendlessDataQuery();
    query.setQueryOptions( queryOptions );
    eBike.findAsync( query, new DefaultCallback<BackendlessCollection<eBike>>( RetrieveRecordActivity.this )
    {
      @Override
      public void handleResponse( BackendlessCollection<eBike> response )
      {
        super.handleResponse( response );
        resultCollection = response;

        AlertDialog.Builder builder = new AlertDialog.Builder( RetrieveRecordActivity.this );
        builder.setTitle( "Property to show:" );
        final String[] properties = { "suspension", "tipo_sensor", "created", "tipo_de_uso", "tipo_cuadro", "precio", "ubicacion_motor", "puntos_de_venta", "peso_total", "material_del_cuadro", "velocidades", "tipo_display", "foto", "autonomia", "pagina_web", "ownerId", "modelo", "objectId", "tamano_ruedas", "updated" };
        builder.setItems( properties, new DialogInterface.OnClickListener()
        {
          @Override
          public void onClick( DialogInterface dialogInterface, int i )
          {
            selectedProperty = properties[ i ];

            AlertDialog.Builder builder = new AlertDialog.Builder( RetrieveRecordActivity.this );
            builder.setTitle( "Related table to show:" );
            builder.setItems( selectedRelatedTablesArray, new DialogInterface.OnClickListener()
            {
              @Override
              public void onClick( DialogInterface dialogInterface, int i )
              {
                selectedRelatedTable = selectedRelatedTablesArray[ i ];
                relation = selectedRelationsArray[ i ];
                if( selectedRelatedTable.equals( "GeoPoint" ) )
                {
                  relatedProperties = new String[] { "Latitude", "Longitude", "Metadata" };
                }
                dialogInterface.cancel();

                AlertDialog.Builder builder = new AlertDialog.Builder( RetrieveRecordActivity.this );
                builder.setTitle( "Related property to show:" );
                if( selectedRelatedTable.equals( "marca" ) )
                {
                  relatedProperties = new String[] { "updated", "tipo_de_via", "email", "ownerId", "objectId", "codigo_postal", "pagina_web", "telefono", "numero", "pais", "nombre_marca", "ciudad", "logo", "direccion", "created" };
                }
                else if( selectedRelatedTable.equals( "eBike" ) )
                {
                  relatedProperties = new String[] { "suspension", "tipo_sensor", "created", "tipo_de_uso", "tipo_cuadro", "precio", "ubicacion_motor", "puntos_de_venta", "peso_total", "material_del_cuadro", "velocidades", "tipo_display", "foto", "autonomia", "pagina_web", "ownerId", "modelo", "objectId", "tamano_ruedas", "updated" };
                }
                else if( selectedRelatedTable.equals( "tiendas" ) )
                {
                  relatedProperties = new String[] { "objectId", "nombre", "ciudad", "pais", "tipo_de_via", "pagina_web", "created", "updated", "codigo_postal", "email", "telefono", "nombre_fabricante", "latitud", "numero", "direccion", "longitud", "ownerId" };
                }
                else if( selectedRelatedTable.equals( "fabricante" ) )
                {
                  relatedProperties = new String[] { "codigo_postal", "ownerId", "ciudad", "objectId", "pais", "updated", "email", "nombre_fabricante", "created", "numero", "telefono", "tipo_de_via", "direccion", "pagina_web" };
                }

                builder.setItems( relatedProperties, new DialogInterface.OnClickListener()
                {
                  @Override
                  public void onClick( DialogInterface dialogInterface, int i )
                  {
                    selectedRelatedProperty = relatedProperties[ i ];
                    dialogInterface.cancel();
                    Intent nextIntent = new Intent( RetrieveRecordActivity.this, ShowEntityActivity.class );
                    nextIntent.putExtra( "type", type );
                    nextIntent.putExtra( "property", selectedProperty );
                    nextIntent.putExtra( "relation", relation );
                    nextIntent.putExtra( "relatedTable", selectedRelatedTable );
                    nextIntent.putExtra( "relatedProperty", selectedRelatedProperty );
                    startActivity( nextIntent );
                    dialogInterface.cancel();
                  }
                } );
                builder.create().show();
              }
            } );
            builder.create().show();
          }
        } );
        builder.create().show();
      }
    } );
  }

  private String getTiendasRetrievalCode()
  {
    if( type.equals( "Basic Find" ) )
    {
      return getBasicTiendasRetrievalCode();
    }
    else if( type.equals( "Find First" ) )
    {
      return getFirstTiendasRetrievalCode();
    }
    else if( type.equals( "Find Last" ) )
    {
      return getLastTiendasRetrievalCode();
    }
    else if( type.equals( "Find with Sort" ) )
    {
      return getSortedTiendasRetrievalCode();
    }
    else if( type.equals( "Find with Relations" ) )
    {
      return getRelatedTiendasRetrievalCode();
    }
    return null;
  }

  private void retrieveTiendasRecord()
  {
    if( type.equals( "Basic Find" ) )
    {
      retrieveBasicTiendasRecord();
    }
    else if( type.equals( "Find First" ) )
    {
      retrieveFirstTiendasRecord();
    }
    else if( type.equals( "Find Last" ) )
    {
      retrieveLastTiendasRecord();
    }
    else if( type.equals( "Find with Sort" ) )
    {
      retrieveSortedTiendasRecord();
    }
    else if( type.equals( "Find with Relations" ) )
    {
      retrieveRelatedTiendasRecord();
    }
  }

  private String getBasicTiendasRetrievalCode()
  {
    return "BackendlessDataQuery query = new BackendlessDataQuery();\n"
            + "tiendas.findAsync( query, new AsyncCallback<BackendlessCollection<tiendas>>()\n"
            + "{\n"
            + "  @Override\n"
            + "  public void handleResponse( BackendlessCollection<tiendas> response )\n"
            + "  {\n"
            + "    tiendas firstTiendas = response.getCurrentPage().get( 0 );\n"
            + "  }\n"
            + "  @Override\n"
            + "  public void handleFault( BackendlessFault fault )\n"
            + "  {\n"
            + "    Toast.makeText( getBaseContext(), fault.getMessage(), Toast.LENGTH_SHORT ).show();\n"
            + "  }\n"
            + "} );";
  }

  private void retrieveBasicTiendasRecord()
  {
    BackendlessDataQuery query = new BackendlessDataQuery();
    tiendas.findAsync( query, new DefaultCallback<BackendlessCollection<tiendas>>( RetrieveRecordActivity.this )
    {
      @Override
      public void handleResponse( BackendlessCollection<tiendas> response )
      {
        super.handleResponse( response );

        resultCollection = response;

        AlertDialog.Builder builder = new AlertDialog.Builder( RetrieveRecordActivity.this );
        builder.setTitle( "Property to show:" );
        final String[] properties = { "objectId", "nombre", "ciudad", "pais", "tipo_de_via", "pagina_web", "created", "updated", "codigo_postal", "email", "telefono", "nombre_fabricante", "latitud", "numero", "direccion", "longitud", "ownerId" };
        builder.setItems( properties, new DialogInterface.OnClickListener()
        {
          @Override
          public void onClick( DialogInterface dialogInterface, int i )
          {
            Intent nextIntent = new Intent( RetrieveRecordActivity.this, ShowByPropertyActivity.class );
            nextIntent.putExtra( "type", type );
            nextIntent.putExtra( "property", properties[ i ] );
            startActivity( nextIntent );
            dialogInterface.cancel();
          }
        } );
        builder.create().show();
      }
    } );
  }

  private String getFirstTiendasRetrievalCode()
  {
    return "tiendas.findFirstAsync( new AsyncCallback<tiendas>()\n"
            + "{\n"
            + "  @Override\n"
            + "  public void handleResponse( tiendas object )\n"
            + "  {\n"
            + "    //work with the object\n"
            + "  }\n"
            + "  @Override\n"
            + "  public void handleFault( BackendlessFault fault )\n"
            + "  {\n"
            + "    Toast.makeText( getBaseContext(), fault.getMessage(), Toast.LENGTH_SHORT ).show();\n"
            + "  }\n"
            + "} );";
  }

  private void retrieveFirstTiendasRecord()
  {
    tiendas.findFirstAsync( new DefaultCallback<tiendas>( RetrieveRecordActivity.this )
    {
      @Override
      public void handleResponse( tiendas response )
      {
        super.handleResponse( response );
        resultObject = response;
        Intent nextIntent = new Intent( RetrieveRecordActivity.this, ShowEntityActivity.class );
        nextIntent.putExtra( "type", type );
        startActivity( nextIntent );
      }
    } );
  }

  private String getLastTiendasRetrievalCode()
  {
    return "tiendas.findLastAsync( new AsyncCallback<tiendas>()\n"
            + "{\n"
            + "  @Override\n"
            + "  public void handleResponse( tiendas object )\n"
            + "  {\n"
            + "    //work with the object\n"
            + "  }\n"
            + "  @Override\n"
            + "  public void handleFault( BackendlessFault fault )\n"
            + "  {\n"
            + "    Toast.makeText( getBaseContext(), fault.getMessage(), Toast.LENGTH_SHORT ).show();\n"
            + "  }\n"
            + "} );";
  }

  private void retrieveLastTiendasRecord()
  {
    tiendas.findLastAsync( new DefaultCallback<tiendas>( RetrieveRecordActivity.this )
    {
      @Override
      public void handleResponse( tiendas response )
      {
        super.handleResponse( response );
        resultObject = response;
        Intent nextIntent = new Intent( RetrieveRecordActivity.this, ShowEntityActivity.class );
        nextIntent.putExtra( "type", type );
        startActivity( nextIntent );
      }
    } );
  }

  private String getSortedTiendasRetrievalCode()
  {
    return "QueryOptions queryOptions = new QueryOptions();\n"
            + "List<String> sortByProperties = new ArrayList<String>();\n"
            + "sortByProperties.add( \"someProperty\" );\n"
            + "queryOptions.setSortBy( sortByProperties );\n"
            + "BackendlessDataQuery query = new BackendlessDataQuery(  );\n"
            + "query.setQueryOptions( queryOptions );\n"
            + "tiendas.findAsync( query, new AsyncCallback<BackendlessCollection<tiendas>>()\n"
            + "{\n"
            + "  @Override\n"
            + "  public void handleResponse( BackendlessCollection<tiendas> response )\n"
            + "  {\n"
            + "    tiendas firstSortedTiendas = response.getCurrentPage().get( 0 );\n"
            + "  }\n"
            + "  @Override\n"
            + "  public void handleFault( BackendlessFault fault )\n"
            + "  {\n"
            + "    Toast.makeText( getBaseContext(), fault.getMessage(), Toast.LENGTH_SHORT ).show();\n"
            + "  }\n"
            + "} );";
  }

  private void retrieveSortedTiendasRecord()
  {
    List<CharSequence> selectedItems = getIntent().getCharSequenceArrayListExtra( "selectedProperties" );
    QueryOptions queryOptions = new QueryOptions();
    List<String> sortByProperties = Arrays.asList( selectedItems.toArray( new String[ selectedItems.size() ] ) );
    queryOptions.setSortBy( sortByProperties );
    BackendlessDataQuery query = new BackendlessDataQuery();
    query.setQueryOptions( queryOptions );
    tiendas.findAsync( query, new DefaultCallback<BackendlessCollection<tiendas>>( RetrieveRecordActivity.this )
    {
      @Override
      public void handleResponse( BackendlessCollection<tiendas> response )
      {
        super.handleResponse( response );

        resultCollection = response;

        AlertDialog.Builder builder = new AlertDialog.Builder( RetrieveRecordActivity.this );
        builder.setTitle( "Property to show:" );
        final String[] properties = { "objectId", "nombre", "ciudad", "pais", "tipo_de_via", "pagina_web", "created", "updated", "codigo_postal", "email", "telefono", "nombre_fabricante", "latitud", "numero", "direccion", "longitud", "ownerId" };
        builder.setItems( properties, new DialogInterface.OnClickListener()
        {
          @Override
          public void onClick( DialogInterface dialogInterface, int i )
          {
            Intent nextIntent = new Intent( RetrieveRecordActivity.this, ShowByPropertyActivity.class );
            nextIntent.putExtra( "type", type );
            nextIntent.putExtra( "property", properties[ i ] );
            startActivity( nextIntent );
            dialogInterface.cancel();
          }
        } );
        builder.create().show();
      }
    } );
  }

  private String getRelatedTiendasRetrievalCode()
  {
    return "QueryOptions queryOptions = new QueryOptions();\n"
            + "List<String> relationsToFind = new ArrayList<String>();\n"
            + "queryOptions.setRelated( relationsToFind );\n"
            + "BackendlessDataQuery query = new BackendlessDataQuery();\n"
            + "query.setQueryOptions( queryOptions );\n"
            + "tiendas.findAsync( query, new AsyncCallback<BackendlessCollection<tiendas>>()\n"
            + "{\n"
            + "  @Override\n"
            + "  public void handleResponse( BackendlessCollection<tiendas> collection )\n"
            + "  {\n"
            + "    //work with objects\n"
            + "  }\n"
            + "  public void handleFault( BackendlessFault fault )\n"
            + "  {\n"
            + "    Toast.makeText( getBaseContext(), fault.getMessage(), Toast.LENGTH_SHORT ).show();\n"
            + "  }\n"
            + "}";
  }

  private void retrieveRelatedTiendasRecord()
  {
    final List<CharSequence> selectedRelations = getIntent().getCharSequenceArrayListExtra( "selectedRelations" );
    final List<CharSequence> selectedRelatedTables = getIntent().getCharSequenceArrayListExtra( "selectedRelatedTables" );
    final String[] selectedRelationsArray = selectedRelations.toArray( new String[ selectedRelations.size() ] );
    final String[] selectedRelatedTablesArray = selectedRelatedTables.toArray( new String[ selectedRelatedTables.size() ] );
    QueryOptions queryOptions = new QueryOptions();
    List<String> relationsToFind = Arrays.asList( selectedRelationsArray );
    queryOptions.setRelated( relationsToFind );
    BackendlessDataQuery query = new BackendlessDataQuery();
    query.setQueryOptions( queryOptions );
    tiendas.findAsync( query, new DefaultCallback<BackendlessCollection<tiendas>>( RetrieveRecordActivity.this )
    {
      @Override
      public void handleResponse( BackendlessCollection<tiendas> response )
      {
        super.handleResponse( response );
        resultCollection = response;

        AlertDialog.Builder builder = new AlertDialog.Builder( RetrieveRecordActivity.this );
        builder.setTitle( "Property to show:" );
        final String[] properties = { "objectId", "nombre", "ciudad", "pais", "tipo_de_via", "pagina_web", "created", "updated", "codigo_postal", "email", "telefono", "nombre_fabricante", "latitud", "numero", "direccion", "longitud", "ownerId" };
        builder.setItems( properties, new DialogInterface.OnClickListener()
        {
          @Override
          public void onClick( DialogInterface dialogInterface, int i )
          {
            selectedProperty = properties[ i ];

            AlertDialog.Builder builder = new AlertDialog.Builder( RetrieveRecordActivity.this );
            builder.setTitle( "Related table to show:" );
            builder.setItems( selectedRelatedTablesArray, new DialogInterface.OnClickListener()
            {
              @Override
              public void onClick( DialogInterface dialogInterface, int i )
              {
                selectedRelatedTable = selectedRelatedTablesArray[ i ];
                relation = selectedRelationsArray[ i ];
                if( selectedRelatedTable.equals( "GeoPoint" ) )
                {
                  relatedProperties = new String[] { "Latitude", "Longitude", "Metadata" };
                }
                dialogInterface.cancel();

                AlertDialog.Builder builder = new AlertDialog.Builder( RetrieveRecordActivity.this );
                builder.setTitle( "Related property to show:" );
                if( selectedRelatedTable.equals( "marca" ) )
                {
                  relatedProperties = new String[] { "updated", "tipo_de_via", "email", "ownerId", "objectId", "codigo_postal", "pagina_web", "telefono", "numero", "pais", "nombre_marca", "ciudad", "logo", "direccion", "created" };
                }
                else if( selectedRelatedTable.equals( "eBike" ) )
                {
                  relatedProperties = new String[] { "suspension", "tipo_sensor", "created", "tipo_de_uso", "tipo_cuadro", "precio", "ubicacion_motor", "puntos_de_venta", "peso_total", "material_del_cuadro", "velocidades", "tipo_display", "foto", "autonomia", "pagina_web", "ownerId", "modelo", "objectId", "tamano_ruedas", "updated" };
                }
                else if( selectedRelatedTable.equals( "tiendas" ) )
                {
                  relatedProperties = new String[] { "objectId", "nombre", "ciudad", "pais", "tipo_de_via", "pagina_web", "created", "updated", "codigo_postal", "email", "telefono", "nombre_fabricante", "latitud", "numero", "direccion", "longitud", "ownerId" };
                }
                else if( selectedRelatedTable.equals( "fabricante" ) )
                {
                  relatedProperties = new String[] { "codigo_postal", "ownerId", "ciudad", "objectId", "pais", "updated", "email", "nombre_fabricante", "created", "numero", "telefono", "tipo_de_via", "direccion", "pagina_web" };
                }

                builder.setItems( relatedProperties, new DialogInterface.OnClickListener()
                {
                  @Override
                  public void onClick( DialogInterface dialogInterface, int i )
                  {
                    selectedRelatedProperty = relatedProperties[ i ];
                    dialogInterface.cancel();
                    Intent nextIntent = new Intent( RetrieveRecordActivity.this, ShowEntityActivity.class );
                    nextIntent.putExtra( "type", type );
                    nextIntent.putExtra( "property", selectedProperty );
                    nextIntent.putExtra( "relation", relation );
                    nextIntent.putExtra( "relatedTable", selectedRelatedTable );
                    nextIntent.putExtra( "relatedProperty", selectedRelatedProperty );
                    startActivity( nextIntent );
                    dialogInterface.cancel();
                  }
                } );
                builder.create().show();
              }
            } );
            builder.create().show();
          }
        } );
        builder.create().show();
      }
    } );
  }

  private String getFabricanteRetrievalCode()
  {
    if( type.equals( "Basic Find" ) )
    {
      return getBasicFabricanteRetrievalCode();
    }
    else if( type.equals( "Find First" ) )
    {
      return getFirstFabricanteRetrievalCode();
    }
    else if( type.equals( "Find Last" ) )
    {
      return getLastFabricanteRetrievalCode();
    }
    else if( type.equals( "Find with Sort" ) )
    {
      return getSortedFabricanteRetrievalCode();
    }
    else if( type.equals( "Find with Relations" ) )
    {
      return getRelatedFabricanteRetrievalCode();
    }
    return null;
  }

  private void retrieveFabricanteRecord()
  {
    if( type.equals( "Basic Find" ) )
    {
      retrieveBasicFabricanteRecord();
    }
    else if( type.equals( "Find First" ) )
    {
      retrieveFirstFabricanteRecord();
    }
    else if( type.equals( "Find Last" ) )
    {
      retrieveLastFabricanteRecord();
    }
    else if( type.equals( "Find with Sort" ) )
    {
      retrieveSortedFabricanteRecord();
    }
    else if( type.equals( "Find with Relations" ) )
    {
      retrieveRelatedFabricanteRecord();
    }
  }

  private String getBasicFabricanteRetrievalCode()
  {
    return "BackendlessDataQuery query = new BackendlessDataQuery();\n"
            + "fabricante.findAsync( query, new AsyncCallback<BackendlessCollection<fabricante>>()\n"
            + "{\n"
            + "  @Override\n"
            + "  public void handleResponse( BackendlessCollection<fabricante> response )\n"
            + "  {\n"
            + "    fabricante firstFabricante = response.getCurrentPage().get( 0 );\n"
            + "  }\n"
            + "  @Override\n"
            + "  public void handleFault( BackendlessFault fault )\n"
            + "  {\n"
            + "    Toast.makeText( getBaseContext(), fault.getMessage(), Toast.LENGTH_SHORT ).show();\n"
            + "  }\n"
            + "} );";
  }

  private void retrieveBasicFabricanteRecord()
  {
    BackendlessDataQuery query = new BackendlessDataQuery();
    fabricante.findAsync( query, new DefaultCallback<BackendlessCollection<fabricante>>( RetrieveRecordActivity.this )
    {
      @Override
      public void handleResponse( BackendlessCollection<fabricante> response )
      {
        super.handleResponse( response );

        resultCollection = response;

        AlertDialog.Builder builder = new AlertDialog.Builder( RetrieveRecordActivity.this );
        builder.setTitle( "Property to show:" );
        final String[] properties = { "codigo_postal", "ownerId", "ciudad", "objectId", "pais", "updated", "email", "nombre_fabricante", "created", "numero", "telefono", "tipo_de_via", "direccion", "pagina_web" };
        builder.setItems( properties, new DialogInterface.OnClickListener()
        {
          @Override
          public void onClick( DialogInterface dialogInterface, int i )
          {
            Intent nextIntent = new Intent( RetrieveRecordActivity.this, ShowByPropertyActivity.class );
            nextIntent.putExtra( "type", type );
            nextIntent.putExtra( "property", properties[ i ] );
            startActivity( nextIntent );
            dialogInterface.cancel();
          }
        } );
        builder.create().show();
      }
    } );
  }

  private String getFirstFabricanteRetrievalCode()
  {
    return "fabricante.findFirstAsync( new AsyncCallback<fabricante>()\n"
            + "{\n"
            + "  @Override\n"
            + "  public void handleResponse( fabricante object )\n"
            + "  {\n"
            + "    //work with the object\n"
            + "  }\n"
            + "  @Override\n"
            + "  public void handleFault( BackendlessFault fault )\n"
            + "  {\n"
            + "    Toast.makeText( getBaseContext(), fault.getMessage(), Toast.LENGTH_SHORT ).show();\n"
            + "  }\n"
            + "} );";
  }

  private void retrieveFirstFabricanteRecord()
  {
    fabricante.findFirstAsync( new DefaultCallback<fabricante>( RetrieveRecordActivity.this )
    {
      @Override
      public void handleResponse( fabricante response )
      {
        super.handleResponse( response );
        resultObject = response;
        Intent nextIntent = new Intent( RetrieveRecordActivity.this, ShowEntityActivity.class );
        nextIntent.putExtra( "type", type );
        startActivity( nextIntent );
      }
    } );
  }

  private String getLastFabricanteRetrievalCode()
  {
    return "fabricante.findLastAsync( new AsyncCallback<fabricante>()\n"
            + "{\n"
            + "  @Override\n"
            + "  public void handleResponse( fabricante object )\n"
            + "  {\n"
            + "    //work with the object\n"
            + "  }\n"
            + "  @Override\n"
            + "  public void handleFault( BackendlessFault fault )\n"
            + "  {\n"
            + "    Toast.makeText( getBaseContext(), fault.getMessage(), Toast.LENGTH_SHORT ).show();\n"
            + "  }\n"
            + "} );";
  }

  private void retrieveLastFabricanteRecord()
  {
    fabricante.findLastAsync( new DefaultCallback<fabricante>( RetrieveRecordActivity.this )
    {
      @Override
      public void handleResponse( fabricante response )
      {
        super.handleResponse( response );
        resultObject = response;
        Intent nextIntent = new Intent( RetrieveRecordActivity.this, ShowEntityActivity.class );
        nextIntent.putExtra( "type", type );
        startActivity( nextIntent );
      }
    } );
  }

  private String getSortedFabricanteRetrievalCode()
  {
    return "QueryOptions queryOptions = new QueryOptions();\n"
            + "List<String> sortByProperties = new ArrayList<String>();\n"
            + "sortByProperties.add( \"someProperty\" );\n"
            + "queryOptions.setSortBy( sortByProperties );\n"
            + "BackendlessDataQuery query = new BackendlessDataQuery(  );\n"
            + "query.setQueryOptions( queryOptions );\n"
            + "fabricante.findAsync( query, new AsyncCallback<BackendlessCollection<fabricante>>()\n"
            + "{\n"
            + "  @Override\n"
            + "  public void handleResponse( BackendlessCollection<fabricante> response )\n"
            + "  {\n"
            + "    fabricante firstSortedFabricante = response.getCurrentPage().get( 0 );\n"
            + "  }\n"
            + "  @Override\n"
            + "  public void handleFault( BackendlessFault fault )\n"
            + "  {\n"
            + "    Toast.makeText( getBaseContext(), fault.getMessage(), Toast.LENGTH_SHORT ).show();\n"
            + "  }\n"
            + "} );";
  }

  private void retrieveSortedFabricanteRecord()
  {
    List<CharSequence> selectedItems = getIntent().getCharSequenceArrayListExtra( "selectedProperties" );
    QueryOptions queryOptions = new QueryOptions();
    List<String> sortByProperties = Arrays.asList( selectedItems.toArray( new String[ selectedItems.size() ] ) );
    queryOptions.setSortBy( sortByProperties );
    BackendlessDataQuery query = new BackendlessDataQuery();
    query.setQueryOptions( queryOptions );
    fabricante.findAsync( query, new DefaultCallback<BackendlessCollection<fabricante>>( RetrieveRecordActivity.this )
    {
      @Override
      public void handleResponse( BackendlessCollection<fabricante> response )
      {
        super.handleResponse( response );

        resultCollection = response;

        AlertDialog.Builder builder = new AlertDialog.Builder( RetrieveRecordActivity.this );
        builder.setTitle( "Property to show:" );
        final String[] properties = { "codigo_postal", "ownerId", "ciudad", "objectId", "pais", "updated", "email", "nombre_fabricante", "created", "numero", "telefono", "tipo_de_via", "direccion", "pagina_web" };
        builder.setItems( properties, new DialogInterface.OnClickListener()
        {
          @Override
          public void onClick( DialogInterface dialogInterface, int i )
          {
            Intent nextIntent = new Intent( RetrieveRecordActivity.this, ShowByPropertyActivity.class );
            nextIntent.putExtra( "type", type );
            nextIntent.putExtra( "property", properties[ i ] );
            startActivity( nextIntent );
            dialogInterface.cancel();
          }
        } );
        builder.create().show();
      }
    } );
  }

  private String getRelatedFabricanteRetrievalCode()
  {
    return "QueryOptions queryOptions = new QueryOptions();\n"
            + "List<String> relationsToFind = new ArrayList<String>();\n"
            + "queryOptions.setRelated( relationsToFind );\n"
            + "BackendlessDataQuery query = new BackendlessDataQuery();\n"
            + "query.setQueryOptions( queryOptions );\n"
            + "fabricante.findAsync( query, new AsyncCallback<BackendlessCollection<fabricante>>()\n"
            + "{\n"
            + "  @Override\n"
            + "  public void handleResponse( BackendlessCollection<fabricante> collection )\n"
            + "  {\n"
            + "    //work with objects\n"
            + "  }\n"
            + "  public void handleFault( BackendlessFault fault )\n"
            + "  {\n"
            + "    Toast.makeText( getBaseContext(), fault.getMessage(), Toast.LENGTH_SHORT ).show();\n"
            + "  }\n"
            + "}";
  }

  private void retrieveRelatedFabricanteRecord()
  {
    final List<CharSequence> selectedRelations = getIntent().getCharSequenceArrayListExtra( "selectedRelations" );
    final List<CharSequence> selectedRelatedTables = getIntent().getCharSequenceArrayListExtra( "selectedRelatedTables" );
    final String[] selectedRelationsArray = selectedRelations.toArray( new String[ selectedRelations.size() ] );
    final String[] selectedRelatedTablesArray = selectedRelatedTables.toArray( new String[ selectedRelatedTables.size() ] );
    QueryOptions queryOptions = new QueryOptions();
    List<String> relationsToFind = Arrays.asList( selectedRelationsArray );
    queryOptions.setRelated( relationsToFind );
    BackendlessDataQuery query = new BackendlessDataQuery();
    query.setQueryOptions( queryOptions );
    fabricante.findAsync( query, new DefaultCallback<BackendlessCollection<fabricante>>( RetrieveRecordActivity.this )
    {
      @Override
      public void handleResponse( BackendlessCollection<fabricante> response )
      {
        super.handleResponse( response );
        resultCollection = response;

        AlertDialog.Builder builder = new AlertDialog.Builder( RetrieveRecordActivity.this );
        builder.setTitle( "Property to show:" );
        final String[] properties = { "codigo_postal", "ownerId", "ciudad", "objectId", "pais", "updated", "email", "nombre_fabricante", "created", "numero", "telefono", "tipo_de_via", "direccion", "pagina_web" };
        builder.setItems( properties, new DialogInterface.OnClickListener()
        {
          @Override
          public void onClick( DialogInterface dialogInterface, int i )
          {
            selectedProperty = properties[ i ];

            AlertDialog.Builder builder = new AlertDialog.Builder( RetrieveRecordActivity.this );
            builder.setTitle( "Related table to show:" );
            builder.setItems( selectedRelatedTablesArray, new DialogInterface.OnClickListener()
            {
              @Override
              public void onClick( DialogInterface dialogInterface, int i )
              {
                selectedRelatedTable = selectedRelatedTablesArray[ i ];
                relation = selectedRelationsArray[ i ];
                if( selectedRelatedTable.equals( "GeoPoint" ) )
                {
                  relatedProperties = new String[] { "Latitude", "Longitude", "Metadata" };
                }
                dialogInterface.cancel();

                AlertDialog.Builder builder = new AlertDialog.Builder( RetrieveRecordActivity.this );
                builder.setTitle( "Related property to show:" );
                if( selectedRelatedTable.equals( "marca" ) )
                {
                  relatedProperties = new String[] { "updated", "tipo_de_via", "email", "ownerId", "objectId", "codigo_postal", "pagina_web", "telefono", "numero", "pais", "nombre_marca", "ciudad", "logo", "direccion", "created" };
                }
                else if( selectedRelatedTable.equals( "eBike" ) )
                {
                  relatedProperties = new String[] { "suspension", "tipo_sensor", "created", "tipo_de_uso", "tipo_cuadro", "precio", "ubicacion_motor", "puntos_de_venta", "peso_total", "material_del_cuadro", "velocidades", "tipo_display", "foto", "autonomia", "pagina_web", "ownerId", "modelo", "objectId", "tamano_ruedas", "updated" };
                }
                else if( selectedRelatedTable.equals( "tiendas" ) )
                {
                  relatedProperties = new String[] { "objectId", "nombre", "ciudad", "pais", "tipo_de_via", "pagina_web", "created", "updated", "codigo_postal", "email", "telefono", "nombre_fabricante", "latitud", "numero", "direccion", "longitud", "ownerId" };
                }
                else if( selectedRelatedTable.equals( "fabricante" ) )
                {
                  relatedProperties = new String[] { "codigo_postal", "ownerId", "ciudad", "objectId", "pais", "updated", "email", "nombre_fabricante", "created", "numero", "telefono", "tipo_de_via", "direccion", "pagina_web" };
                }

                builder.setItems( relatedProperties, new DialogInterface.OnClickListener()
                {
                  @Override
                  public void onClick( DialogInterface dialogInterface, int i )
                  {
                    selectedRelatedProperty = relatedProperties[ i ];
                    dialogInterface.cancel();
                    Intent nextIntent = new Intent( RetrieveRecordActivity.this, ShowEntityActivity.class );
                    nextIntent.putExtra( "type", type );
                    nextIntent.putExtra( "property", selectedProperty );
                    nextIntent.putExtra( "relation", relation );
                    nextIntent.putExtra( "relatedTable", selectedRelatedTable );
                    nextIntent.putExtra( "relatedProperty", selectedRelatedProperty );
                    startActivity( nextIntent );
                    dialogInterface.cancel();
                  }
                } );
                builder.create().show();
              }
            } );
            builder.create().show();
          }
        } );
        builder.create().show();
      }
    } );
  }
}
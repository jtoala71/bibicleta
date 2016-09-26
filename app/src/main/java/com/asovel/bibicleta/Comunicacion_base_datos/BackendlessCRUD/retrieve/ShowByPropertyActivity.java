package com.asovel.bibicleta.Comunicacion_base_datos.BackendlessCRUD.retrieve;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.backendless.BackendlessCollection;
import com.asovel.bibicleta.Comunicacion_base_datos.BackendlessData.*;
import com.asovel.bibicleta.R;
import com.asovel.bibicleta.Comunicacion_base_datos.BackendlessCRUD.common.DataApplication;
import com.asovel.bibicleta.Comunicacion_base_datos.BackendlessCRUD.common.DefaultCallback;

public class ShowByPropertyActivity extends Activity
{
  private TextView titleView;
  private TextView propertyView;
  private ListView entitiesView;
  private Button nextPageButton, previousPageButton;

  private String type;
  private String table;
  private String property;
  private BackendlessCollection collection;
  private String[] items;

  private int currentPage;
  private int totalPages;

  public void onCreate( Bundle savedInstanceState )
  {
    super.onCreate( savedInstanceState );
    setContentView( R.layout.show_by_property );

    DataApplication dataApplication = (DataApplication) getApplication();
    table = dataApplication.getChosenTable();

    collection = RetrieveRecordActivity.getResultCollection();
    currentPage = 1;
    totalPages = (int) Math.ceil( ((double) collection.getTotalObjects()) / collection.getCurrentPage().size() );

    initUI();
    initList();
    initButtons();
  }

  private void initUI()
  {
    titleView = (TextView) findViewById( R.id.showByPropertyTitle );
    propertyView = (TextView) findViewById( R.id.propertyName );
    entitiesView = (ListView) findViewById( R.id.entitiesList );
    previousPageButton = (Button) findViewById( R.id.previousPageButton );
    nextPageButton = (Button) findViewById( R.id.nextPageButton );

    Intent intent = getIntent();
    type = intent.getStringExtra( "type" );
    property = intent.getStringExtra( "property" );

    if( type.equals( "Basic Find" ) )
    {
      titleView.setText( "Basic Find" );
    }
    else if( type.equals( "Find with Sort" ) )
    {
      titleView.setText( "Sorted Find" );
    }
    propertyView.setText( property + ":" );

    previousPageButton.setOnClickListener( new View.OnClickListener()
    {
      @Override
      public void onClick( View view )
      {
        collection.previousPage( new DefaultCallback<BackendlessCollection>( ShowByPropertyActivity.this )
        {
          @Override
          public void handleResponse( BackendlessCollection response )
          {
            currentPage--;
            collection = response;
            initList();
            initButtons();
            super.handleResponse( response );
          }
        } );
      }
    } );

    nextPageButton.setOnClickListener( new View.OnClickListener()
    {
      @Override
      public void onClick( View view )
      {
        collection.nextPage( new DefaultCallback<BackendlessCollection>( ShowByPropertyActivity.this )
        {
          @Override
          public void handleResponse( BackendlessCollection response )
          {
            currentPage++;
            collection = response;
            initList();
            initButtons();
            super.handleResponse( response );
          }
        } );
      }
    } );
  }

  private void initList()
  {
    items = new String[ collection.getCurrentPage().size() ];

    if( table.equals( "marca" ) )
    {
      if( property.equals( "updated" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((marca) collection.getCurrentPage().get( i )).getUpdated() );
        }
      }
      else if( property.equals( "tipo_de_via" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((marca) collection.getCurrentPage().get( i )).getTipo_de_via() );
        }
      }
      else if( property.equals( "email" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((marca) collection.getCurrentPage().get( i )).getEmail() );
        }
      }
      else if( property.equals( "ownerId" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((marca) collection.getCurrentPage().get( i )).getOwnerId() );
        }
      }
      else if( property.equals( "objectId" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((marca) collection.getCurrentPage().get( i )).getObjectId() );
        }
      }
      else if( property.equals( "codigo_postal" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((marca) collection.getCurrentPage().get( i )).getCodigo_postal() );
        }
      }
      else if( property.equals( "pagina_web" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((marca) collection.getCurrentPage().get( i )).getPagina_web() );
        }
      }
      else if( property.equals( "telefono" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((marca) collection.getCurrentPage().get( i )).getTelefono() );
        }
      }
      else if( property.equals( "numero" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((marca) collection.getCurrentPage().get( i )).getNumero() );
        }
      }
      else if( property.equals( "pais" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((marca) collection.getCurrentPage().get( i )).getPais() );
        }
      }
      else if( property.equals( "nombre_marca" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((marca) collection.getCurrentPage().get( i )).getNombre_marca() );
        }
      }
      else if( property.equals( "ciudad" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((marca) collection.getCurrentPage().get( i )).getCiudad() );
        }
      }
      else if( property.equals( "logo" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((marca) collection.getCurrentPage().get( i )).getLogo() );
        }
      }
      else if( property.equals( "direccion" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((marca) collection.getCurrentPage().get( i )).getDireccion() );
        }
      }
      else if( property.equals( "created" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((marca) collection.getCurrentPage().get( i )).getCreated() );
        }
      }
    }
    else if( table.equals( "eBike" ) )
    {
      if( property.equals( "suspension" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((eBike) collection.getCurrentPage().get( i )).getSuspension() );
        }
      }
      else if( property.equals( "tipo_sensor" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((eBike) collection.getCurrentPage().get( i )).getTipo_sensor() );
        }
      }
      else if( property.equals( "created" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((eBike) collection.getCurrentPage().get( i )).getCreated() );
        }
      }
      else if( property.equals( "tipo_de_uso" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((eBike) collection.getCurrentPage().get( i )).getTipo_de_uso() );
        }
      }
      else if( property.equals( "tipo_cuadro" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((eBike) collection.getCurrentPage().get( i )).getTipo_cuadro() );
        }
      }
      else if( property.equals( "precio" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((eBike) collection.getCurrentPage().get( i )).getPrecio() );
        }
      }
      else if( property.equals( "ubicacion_motor" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((eBike) collection.getCurrentPage().get( i )).getUbicacion_motor() );
        }
      }
      else if( property.equals( "puntos_de_venta" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((eBike) collection.getCurrentPage().get( i )).getPuntos_de_venta() );
        }
      }
      else if( property.equals( "peso_total" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((eBike) collection.getCurrentPage().get( i )).getPeso_total() );
        }
      }
      else if( property.equals( "material_del_cuadro" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((eBike) collection.getCurrentPage().get( i )).getMaterial_del_cuadro() );
        }
      }
      else if( property.equals( "velocidades" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((eBike) collection.getCurrentPage().get( i )).getVelocidades() );
        }
      }
      else if( property.equals( "tipo_display" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((eBike) collection.getCurrentPage().get( i )).getTipo_display() );
        }
      }
      else if( property.equals( "foto" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((eBike) collection.getCurrentPage().get( i )).getFoto() );
        }
      }
      else if( property.equals( "autonomia" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((eBike) collection.getCurrentPage().get( i )).getAutonomia() );
        }
      }
      else if( property.equals( "pagina_web" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((eBike) collection.getCurrentPage().get( i )).getPagina_web() );
        }
      }
      else if( property.equals( "ownerId" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((eBike) collection.getCurrentPage().get( i )).getOwnerId() );
        }
      }
      else if( property.equals( "modelo" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((eBike) collection.getCurrentPage().get( i )).getModelo() );
        }
      }
      else if( property.equals( "objectId" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((eBike) collection.getCurrentPage().get( i )).getObjectId() );
        }
      }
      else if( property.equals( "tamano_ruedas" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((eBike) collection.getCurrentPage().get( i )).getTamano_ruedas() );
        }
      }
      else if( property.equals( "updated" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((eBike) collection.getCurrentPage().get( i )).getUpdated() );
        }
      }
    }
    else if( table.equals( "tiendas" ) )
    {
      if( property.equals( "objectId" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((tiendas) collection.getCurrentPage().get( i )).getObjectId() );
        }
      }
      else if( property.equals( "nombre" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((tiendas) collection.getCurrentPage().get( i )).getNombre() );
        }
      }
      else if( property.equals( "ciudad" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((tiendas) collection.getCurrentPage().get( i )).getCiudad() );
        }
      }
      else if( property.equals( "pais" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((tiendas) collection.getCurrentPage().get( i )).getPais() );
        }
      }
      else if( property.equals( "tipo_de_via" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((tiendas) collection.getCurrentPage().get( i )).getTipo_de_via() );
        }
      }
      else if( property.equals( "pagina_web" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((tiendas) collection.getCurrentPage().get( i )).getPagina_web() );
        }
      }
      else if( property.equals( "created" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((tiendas) collection.getCurrentPage().get( i )).getCreated() );
        }
      }
      else if( property.equals( "updated" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((tiendas) collection.getCurrentPage().get( i )).getUpdated() );
        }
      }
      else if( property.equals( "codigo_postal" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((tiendas) collection.getCurrentPage().get( i )).getCodigo_postal() );
        }
      }
      else if( property.equals( "email" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((tiendas) collection.getCurrentPage().get( i )).getEmail() );
        }
      }
      else if( property.equals( "telefono" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((tiendas) collection.getCurrentPage().get( i )).getTelefono() );
        }
      }
      else if( property.equals( "nombre_fabricante" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((tiendas) collection.getCurrentPage().get( i )).getNombre_fabricante() );
        }
      }
      else if( property.equals( "latitud" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((tiendas) collection.getCurrentPage().get( i )).getLatitud() );
        }
      }
      else if( property.equals( "numero" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((tiendas) collection.getCurrentPage().get( i )).getNumero() );
        }
      }
      else if( property.equals( "direccion" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((tiendas) collection.getCurrentPage().get( i )).getDireccion() );
        }
      }
      else if( property.equals( "longitud" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((tiendas) collection.getCurrentPage().get( i )).getLongitud() );
        }
      }
      else if( property.equals( "ownerId" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((tiendas) collection.getCurrentPage().get( i )).getOwnerId() );
        }
      }
    }
    else if( table.equals( "fabricante" ) )
    {
      if( property.equals( "codigo_postal" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((fabricante) collection.getCurrentPage().get( i )).getCodigo_postal() );
        }
      }
      else if( property.equals( "ownerId" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((fabricante) collection.getCurrentPage().get( i )).getOwnerId() );
        }
      }
      else if( property.equals( "ciudad" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((fabricante) collection.getCurrentPage().get( i )).getCiudad() );
        }
      }
      else if( property.equals( "objectId" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((fabricante) collection.getCurrentPage().get( i )).getObjectId() );
        }
      }
      else if( property.equals( "pais" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((fabricante) collection.getCurrentPage().get( i )).getPais() );
        }
      }
      else if( property.equals( "updated" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((fabricante) collection.getCurrentPage().get( i )).getUpdated() );
        }
      }
      else if( property.equals( "email" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((fabricante) collection.getCurrentPage().get( i )).getEmail() );
        }
      }
      else if( property.equals( "nombre_fabricante" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((fabricante) collection.getCurrentPage().get( i )).getNombre_fabricante() );
        }
      }
      else if( property.equals( "created" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((fabricante) collection.getCurrentPage().get( i )).getCreated() );
        }
      }
      else if( property.equals( "numero" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((fabricante) collection.getCurrentPage().get( i )).getNumero() );
        }
      }
      else if( property.equals( "telefono" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((fabricante) collection.getCurrentPage().get( i )).getTelefono() );
        }
      }
      else if( property.equals( "tipo_de_via" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((fabricante) collection.getCurrentPage().get( i )).getTipo_de_via() );
        }
      }
      else if( property.equals( "direccion" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((fabricante) collection.getCurrentPage().get( i )).getDireccion() );
        }
      }
      else if( property.equals( "pagina_web" ) )
      {
        for( int i = 0; i < collection.getCurrentPage().size(); i++ )
        {
          items[ i ] = String.valueOf( ((fabricante) collection.getCurrentPage().get( i )).getPagina_web() );
        }
      }
    }

    ListAdapter adapter = new ArrayAdapter( this, android.R.layout.simple_list_item_1, items );
    entitiesView.setAdapter( adapter );
  }

  private void initButtons()
  {
    previousPageButton.setEnabled( currentPage != 1 );
    nextPageButton.setEnabled( currentPage != totalPages );
  }
}
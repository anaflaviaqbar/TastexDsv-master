package com.example.anafl.projetofirebase.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anafl.projetofirebase.Entidades.Usuario;
import com.example.anafl.projetofirebase.Listas.VendedorAdapter;
import com.example.anafl.projetofirebase.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Comprar.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class Comprar extends Fragment {

    private OnFragmentInteractionListener mListener;

    private RecyclerView mRecyclerView;
    private VendedorAdapter vendedorAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private List<Usuario> listVendedores;
    public Comprar() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_comprar, container, false);




        criarListaVendedores();

        //Aqui é instanciado o Recyclerview
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_vendedores);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        vendedorAdapter = new VendedorAdapter(listVendedores);
        mRecyclerView.setAdapter(vendedorAdapter);

        return view;



    }

    private void criarListaVendedores() {

        listVendedores = new ArrayList<Usuario>();

        listVendedores.add(new Usuario("Ronaldo"));
        listVendedores.add(new Usuario("Neymar"));
        listVendedores.add(new Usuario("Ciclano"));
        listVendedores.add(new Usuario("Teste"));
        listVendedores.add(new Usuario("Fulana"));
        listVendedores.add(new Usuario("Maria"));
        listVendedores.add(new Usuario("Mariana"));
        listVendedores.add(new Usuario("Ronaldo"));
        listVendedores.add(new Usuario("Neymar"));
        listVendedores.add(new Usuario("Ciclano"));
        listVendedores.add(new Usuario("Teste"));
        listVendedores.add(new Usuario("Fulana"));
        listVendedores.add(new Usuario("Maria"));
        listVendedores.add(new Usuario("Mariana"));
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private void setaRecyclerView() {

        //Aqui é instanciado o Recyclerview

    }
}

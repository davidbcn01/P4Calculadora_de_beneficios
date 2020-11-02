package com.example.calculador_de_beneficios;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MiCalculadoraViewModel extends AndroidViewModel {
    Executor executor;

    SimuladorCalculadora simulador;

    MutableLiveData<Double> beneficio = new MutableLiveData<>();

    public MiCalculadoraViewModel(@NonNull Application application) {
        super(application);

        executor = Executors.newSingleThreadExecutor();
        simulador = new SimuladorCalculadora();
    }

    public void calcular(double compra, double venta, int interes) {

        final SimuladorCalculadora.Solicitud solicitud = new SimuladorCalculadora.Solicitud(compra,venta,interes);

        executor.execute(new Runnable() {
            @Override
            public void run() {
                double resultado = simulador.calcular(solicitud);
                beneficio.postValue(resultado);
            }
        });
    }
}



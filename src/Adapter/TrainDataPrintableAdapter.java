package Adapter;

import Adapter.Printable;

public class TrainDataPrintableAdapter implements Printable {
    @Override
    public void print(String message) {
        System.out.println(message.substring(0, message.length() - 2) + '.');
    }
}

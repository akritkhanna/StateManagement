package com.example.statemanagement.api;

public class Resources<T> {
       private T data;
       private States state;
       private String errorMessage;



       public Resources(T data, States state, String errorMessage) {
              this.data = data;
              this.state = state;
              this.errorMessage = errorMessage;
       }

       public T getData() {
              return data;
       }

       public States getState() {
              return state;
       }

       public String getErrorMessage() {
              return errorMessage;
       }

       /*       public Resources<T> success(){
              return new Resources<>(data, States.SUCCESS, null);
       }

       public Resources<T> loading(){
              return new Resources<>(null, States.LOADING, null);
       }

       public Resources<T> error(){
              return new Resources<>(null, States.ERROR, errorMessage);
       }*/
}

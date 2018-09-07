package com.zawzaww.padc.mmnewskotlin.events

class ErrorEvent {

    class ApiErrorEvent(val throwable: Throwable? = null) {

        fun getMsg(): String? {
            if (throwable == null)
                return "Null Throwable in Error"
            else
                return throwable.message
        }
    }
}
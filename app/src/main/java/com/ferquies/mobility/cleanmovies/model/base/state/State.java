package com.ferquies.mobility.cleanmovies.model.base.state;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.NotNull;

public abstract class State implements Comparable<State> {
    public static class Loading extends State {
        @NonNull
        @Override
        public String toString() {
            return "State.Loading";
        }

        @Override
        public int compareTo(@NotNull State object) {
            return (object instanceof Loading ? 0 : -1);
        }
    }

    public static class Error extends State {
        private final String error;

        public Error(String error) {
            this.error = error;
        }

        public String getError() {
            return error;
        }

        @NonNull
        @Override
        public String toString() {
            return "State.Error: " + error;
        }

        @Override
        public int compareTo(@NotNull State object) {
            if (object instanceof Error) {
                return error.equals(((Error) object).getError()) ? 0 : -1;
            }

            return -1;
        }
    }

    public static class NoContent extends State {
        @NonNull
        @Override
        public String toString() {
            return "State.NoContent";
        }

        @Override
        public int compareTo(@NotNull State object) {
            return (object instanceof NoContent ? 0 : -1);
        }
    }

    public static class Content<T> extends State {
        private T content;

        public Content(T content) {
            this.content = content;
        }

        public T getContent() {
            return content;
        }

        @NonNull
        @Override
        public String toString() {
            return "State.Content: " + (content == null ? "null" : content.toString());
        }

        @Override
        public int compareTo(@NotNull State object) {
            if (object instanceof Content) {
                return content.equals(((Content) object).getContent()) ? 0 : -1;
            }

            return -1;
        }
    }


}


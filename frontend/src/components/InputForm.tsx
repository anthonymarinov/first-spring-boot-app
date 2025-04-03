"use client";

import { useRef } from "react";
import Form from "next/form";
import { FormEvent } from "react";

export default function InputForm() {

    const apiURL = "http://localhost:8090/api";
    const todosAPI = "/todos";

    const nameInput = useRef(null);

    // TODO
    async function addTodo(event: FormEvent<HTMLFormElement>): Promise<void> {
        event.preventDefault();
        try{
            const response = await fetch(apiURL + todosAPI, {
                method: "POST",
                body: nameInput.current.value,
            });

            const result = await response.json();
            console.log("success: ", result.message);
        } catch (error) {
            console.error(error);
        }
    }

    return (
        <Form className="flex flex-row space-x-5"
                action="" onSubmit={addTodo}
                >
            <input type="text"
                    className="bg-white text-black"
                    placeholder="name">
            </input>
            <button type="submit"
                    className="border hover:bg-gray-800 p-2">
                Add Name
            </button>
        </Form>
    );
}
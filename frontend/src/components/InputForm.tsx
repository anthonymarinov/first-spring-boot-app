"use client";

import { useRef } from "react";
import Form from "next/form";
import { FormEvent } from "react";
import { useRouter } from "next/navigation";

export default function InputForm() {

    const apiURL:string = "http://localhost:8090/api";
    const todosAPI: string = "/todos";
    const nameAPIParam: string = "?name=";

    interface TodoData {
        name: string;
    }

    const formRef = useRef<HTMLInputElement>(null);
    const router = useRouter();

    const handleSubmit = async (event: FormEvent) => {
        event.preventDefault();
        if (!formRef.current) return;
        const data: TodoData = {
            name: formRef.current.value as string
        };
        try{
            const response = await fetch(apiURL + todosAPI + nameAPIParam + data.name, {
                method: "POST",
            });

            const result = await response.text();
            console.log("success: ", result);
        } catch (error) {
            console.error(error);
        }
        formRef.current.value = "";
        router.refresh();
    }

    async function addTodo(event: FormEvent) {
        event.preventDefault();
        const formData = new FormData(event.target as HTMLFormElement);
        const data: TodoData = {
            name: formData.get("name") as string
        };
        try{
            const response = await fetch(apiURL + todosAPI + nameAPIParam + data.name, {
                method: "POST",
            });

            const result = await response.text();
            console.log("success: ", result);
        } catch (error) {
            console.error(error);
        }
    }

    return (
        <Form className="flex flex-row space-x-5"
                action="" onSubmit={handleSubmit}
                >
            <input type="text" name="name"
                    className="bg-white text-black"
                    placeholder="name" ref={formRef}>
            </input>
            <button type="submit"
                    className="border hover:bg-gray-800 p-2">
                Add Name
            </button>
        </Form>
    );
}
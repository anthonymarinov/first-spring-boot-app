import InputForm from "@/components/InputForm";

export default async function Home() {

    const apiURL = "http://localhost:8090/api";
    const todosAPI = "/todos";
    
    interface Todo {
        id: string;
        name: string;
    }

    async function getTodos(): Promise<string | string[] | undefined> {
        try {
            const response = await fetch(apiURL + todosAPI);
            const todoList: Todo[] = await response.json();
            if (!todoList) return;
            if (todoList.length == 0) {
                return "Nothing to complete!"
            } else {
                const stringArray: string[] = [];
                for (const todo of todoList) {
                    stringArray.push(todo.name);
                }
                return stringArray;
            }
        } catch (error) {
            console.error(error);
        }
    }

    // TODO: make input form a next component with "use client"

    const todos = getTodos();;

  return (
    <div className="container mx-auto">
        <h1>Things To Do</h1>
        <p>{todos}</p>
        <br/>
        <InputForm />
    </div>
  );
}

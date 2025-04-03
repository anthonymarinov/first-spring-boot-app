export default async function Home() {
    interface Todo {
        id: string;
        name: string;
    }

    const apiURL = "http://localhost:8090/api";
    const todosAPI = "/todos";

    // const submitButton = document.querySelector("button") as HTMLButtonElement;
    // const formInput = document.querySelector("input") as HTMLInputElement; 

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

    async function uploadName(data: Todo) {
        try {
            const response = await fetch(apiURL + todosAPI, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(data)
            });
            
            const result = await response.json();
            console.log("success: ", result.message);
        } catch (error) {
            console.error(error);
        }
    }

    /*
    async function addName() {
        if (!formInput) return;
        const data = { name: formInput.value };
        await uploadName(data);
        formInput.value = "";
    }
    */

    const todos = getTodos();;

  return (
    <div className="container mx-auto">
        <h1>Things To Do</h1>
        <p>{todos}</p>

        <br/>

        <form className="flex flex-row space-x-5">
            <input type="text"
                    className="bg-white text-black"
                    placeholder="name">
            </input>
            <button type="submit"
                    className="bg-blue-300 p-2">
                Add Name
            </button>
        </form>
    </div>
  );
}

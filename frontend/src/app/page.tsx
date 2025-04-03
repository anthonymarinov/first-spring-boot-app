import Image from "next/image";

export default async function Home() {
    const apiURL = "http://localhost:8090/api";

    const introData = await fetch(apiURL + "/index");
    const introText: string = await introData.text(); 

    const nameData = await fetch(apiURL + "/data");
    const names: string[] = await nameData.json();

  return (
    <div>
        <h1>{introText}</h1>
        <p>{Array.from(names)}</p>
    </div>
  );
}

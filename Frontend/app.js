const artworks =[
    {id: 1, title: "Sunset", artist:"Venkatesh", image:""},
    {id: 2, title: "Ocean Breeze", artist: "Aadhi", image:""},
    //More artwork objects here...
    
];

function displayArtworks(filteredArtworks)
{
    const gallery = document.getElementById('artwork-gallery');
    gallery.innerHTML = ''; //Clear existing content

    filteredArtworks.forEach(artwork =>
        {
        const card = document.createElement('div');
        card.classList.add('artwork-card');
        card.innerHTML = `
        <img src="images/${artwork.image}" alt="${artwork.title}">
        <h3>${artwork.title}</h3>
        <p>by ${artwork.artist}</p>
    `;
    gallery.appendChild(card);
});
}

document.getElementById('search').addEventListener('input', function(){
    const query = this.ariaValueMax.toLowerCase();
    const filtered = artworks.filter(artwork =>
        artwork.title.toLowerCase().includes(query)
    );
    displayArtworks(filtered);
});
displayArtworks(artworks);
fetch('http://localhost:8080/artworks')
  .then(response => response.json())
  .then(data => {
    artworks = data;
    displayArtworks(artworks);
  })
  .catch(error => console.error('Error fetching data:', error));

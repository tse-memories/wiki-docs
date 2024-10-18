#!/bin/bash

# Navigate to the root folder
cd .

# Loop through each subfolder
for folder in */; do
    # Navigate into the subfolder
    cd "$folder"
    
    # Check if package.json exists
    if [ -f "package.json" ]; then
        echo "Installing tse-memories-core@latest in $folder"
        # Run npm i tse-memories-core@latest
        npm i tse-memories-core@latest
    else
        echo "No package.json found in $folder, skipping..."
    fi
    
    # Navigate back to the root folder
    cd ..
done

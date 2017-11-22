//// page 374


LinkedList<Person> findPathBiBFS(HashMap<Integer, Person> people, int source, int destination)
{
	BFSDate sourceData = new BFSData(people.get(source));
	BFSData destData = new BFSData(people.get(destination));

	while (!sourceData.isFinished() && !destData.isFinished()) {
		/* Search out from source */
		Person collision = searchLevel(people, sourceData, destData);
		if (collision != null) {
			return mergePaths(sourceData, destData, collision.getID());
		}

		/* Search out from destination. */
		collision = searchLevel(people, destData, sourceData);
		if (collision != null) {
			return mergePaths(sourceData, destData, collision.getID());
		}

	}
	return null;
}

Person searchLevel(HashMap<Integer, Person> people, BFSData primary, BFSData secondary) {

	
}